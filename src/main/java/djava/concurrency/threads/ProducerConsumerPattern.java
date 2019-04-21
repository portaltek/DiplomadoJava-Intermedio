package djava.concurrency.threads;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerPattern {
	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerPattern producerConsumerPattern = new ProducerConsumerPattern();
//		producerConsumerPattern.testWithBlockingQueue();
		producerConsumerPattern.testWithCustomBlockingQueue();
	}

	private void testWithCustomBlockingQueue() throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

		final Runnable producer = () -> {
			while (true) {
				try {
					queue.put(new Integer(1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(producer).start();
		new Thread(producer).start();

		final Runnable consumer = () -> {
			while (true) {
				try {
					Integer i = queue.take();
					System.out.println(i);
					// Process
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(consumer).start();
		new Thread(consumer).start();

		Thread.sleep(1000);
	}

	private static class MyBlockingQueue<E> {
		private Queue<E> queue;
		private int max = 16;
		private ReentrantLock lock = new ReentrantLock(true);
		private Condition notEmpty = lock.newCondition();
		private Condition notFull = lock.newCondition();

		public MyBlockingQueue(Queue<E> queue, int max) {
			this.queue = queue;
			this.max = max;
		}

		public void put(E e) {
			lock.lock();
			try {
				while (queue.size() == max) {
					notFull.await();
				}
				queue.add(e);
				notEmpty.signalAll();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		public E take() {
			lock.lock();
			try {
				while (queue.size() == 0) {
					notEmpty.await();
				}
				E item = queue.remove();
				notFull.signalAll();
				return item;
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				lock.unlock();
			}
			return null;
		}
	}

	private static class MyBlockingQueue2<E> {
		private Queue<E> queue;
		private int max = 16;
		private Object notEmpty = new Object();
		private Object notFull = new Object();

		public MyBlockingQueue2(Queue<E> queue, int max) {
			this.queue = queue;
			this.max = max;
		}

		public synchronized void put(E e) throws InterruptedException {
			while (queue.size() == max) {
				notFull.wait();
			}
			queue.add(e);
			notEmpty.notifyAll();
		}

		public synchronized E take() throws InterruptedException {
			while (queue.size() == 0) {
				notEmpty.wait();
			}
			E item = queue.remove();
			notFull.notifyAll();
			return item;
		}
	}

	private void testWithBlockingQueue() throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

		final Runnable producer = () -> {
			while (true) {
				try {
					queue.put(new Integer(1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(producer).start();
		new Thread(producer).start();

		final Runnable consumer = () -> {
			while (true) {
				try {
					Integer i = queue.take();
					// Process
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(consumer).start();
		new Thread(consumer).start();

		Thread.sleep(1000);
	}

}
