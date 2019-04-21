package djava.concurrency.threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadWriteLockDemo {
	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private static ReadLock readLock = lock.readLock();
	private static WriteLock writeLock = lock.writeLock();

	private static void readResource() {
		
		try {
			readLock.lock(); 
			System.out.println(Thread.currentThread().getName());
		} finally {
			readLock.unlock();
		}
	}
	
	private static void writeResource() {
		
		try {
			writeLock.lock(); 
			System.out.println(Thread.currentThread().getName());
		} finally {
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {
		new Thread(ReentrantReadWriteLockDemo::readResource).start();
		new Thread(ReentrantReadWriteLockDemo::readResource).start();
		new Thread(ReentrantReadWriteLockDemo::writeResource).start();
		new Thread(ReentrantReadWriteLockDemo::writeResource).start();
		new Thread(ReentrantReadWriteLockDemo::writeResource).start();
	}
}
