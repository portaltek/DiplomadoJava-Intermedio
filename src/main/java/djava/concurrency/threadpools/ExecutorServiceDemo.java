package djava.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	private static final int CORE_COUNT = Runtime.getRuntime().availableProcessors(); // If task is CPU Consuming
	@SuppressWarnings("unused")
	private static final int IO_TASKS_COUNT = 100; // If task is IO Consuming. Number of IO tasks.

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo();
//		executorServiceDemo.usingThreadsInnefficiently();
		executorServiceDemo.usingThreadsFromFixedThreadPool();

	}

	/*
	 * FixedThreadPool CachedThreadPool ScheduledThreadPool SinglThreadedExecutor
	 */

	public void usingThreadsFromFixedThreadPool() {
		ExecutorService service = Executors.newFixedThreadPool(CORE_COUNT);
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	public void usingThreadsFromCachedThreadPool() {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	public void usingThreadsFromScheduledThreadPool() {
		ExecutorService service = Executors.newScheduledThreadPool(CORE_COUNT);
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	public void usingThreadsFromSingleThreadPool() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	public void usingThreadsInnefficiently() {
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(new Task());
			t1.start();
		}
	}

	private static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}

	}
}
