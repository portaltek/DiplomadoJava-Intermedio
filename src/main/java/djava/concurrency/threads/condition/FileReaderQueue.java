package djava.concurrency.threads.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileReaderQueue {

	private Object[] elems = null;
	private int current = 0;
	private int placeIndex = 0;
	private int removeIndex = 0;

	private final Lock lock = new ReentrantLock();
	private final Condition isEmpty = lock.newCondition();
	private final Condition isFull = lock.newCondition();

	public FileReaderQueue(int capacity) {
		this.elems = new Object[capacity];
	}

	public void add(Object elem) throws InterruptedException {
		lock.lock();
		while (current >= elems.length) {
			isFull.await(); // If full wait Consumer removes one or more element
		}

		elems[placeIndex] = elem;

		// We need the module, in order to avoid going out of bounds.
		placeIndex = (placeIndex + 1) % elems.length;

		++current;

		// Notify the consumer that there is data available.
		isEmpty.signal();

		lock.unlock();
	}

	public Object remove() throws InterruptedException {
		Object elem = null;

		lock.lock();
		while (current <= 0) {
			isEmpty.await(); // If queue is empty wait for Producer to create elements
		}

		elem = elems[removeIndex];

		// We need the module, in order to avoid going out of bounds.
		removeIndex = (removeIndex + 1) % elems.length;

		--current;

		// Notify the producer that there is space available.
		isFull.signal();

		lock.unlock();

		return elem;
	}
}
