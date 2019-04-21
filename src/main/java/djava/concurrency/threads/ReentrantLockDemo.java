package djava.concurrency.threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	private static ReentrantLock lock = new ReentrantLock();

	private static void accessResource() {
		
		try {
			lock.lock(); 
			System.out.println(Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		new Thread(ReentrantLockDemo::accessResource).start();
		new Thread(ReentrantLockDemo::accessResource).start();
		new Thread(ReentrantLockDemo::accessResource).start();
		new Thread(ReentrantLockDemo::accessResource).start();
		new Thread(ReentrantLockDemo::accessResource).start();
	}
}
