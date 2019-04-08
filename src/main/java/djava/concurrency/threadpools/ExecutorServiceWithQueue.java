package djava.concurrency.threadpools;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceWithQueue {

	private static final int CORE_COUNT = Runtime.getRuntime().availableProcessors(); // If task is CPU Consuming
	@SuppressWarnings("unused")
	private static final int IO_TASKS_COUNT = 100; // If task is IO Consuming. Number of IO tasks.

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ExecutorServiceWithQueue executorServiceWithQueue = new ExecutorServiceWithQueue();

		executorServiceWithQueue.usingCallableFutures();

	}

	/*
	 * FixedThreadPool CachedThreadPool ScheduledThreadPool SinglThreadedExecutor
	 */

	public void usingThreadsFromFixedThreadPool() { // LinkedBlockingQueue
		ExecutorService service = Executors.newFixedThreadPool(CORE_COUNT);
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	public void usingThreadsFromCachedThreadPool() { // SynchronousQueue
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	public void usingThreadsFromScheduledThreadPool() {// DelayedWorkQueue
		ExecutorService service = Executors.newScheduledThreadPool(CORE_COUNT);
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	public void usingThreadsFromSingleThreadPool() { // LinkedBlockingQueue
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}
	}

	// CUSTOM: ArrayBlockingQueue

	private static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}

	}

	private static class TaskCallable implements Callable<Integer> {

		@Override
		public Integer call() throws InterruptedException {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName());
			return 0;
		}

	}

	public void usingCallableFutures() { // LinkedBlockingQueue
		ExecutorService service = Executors.newFixedThreadPool(CORE_COUNT);
		Future<Integer> future = service.submit(new TaskCallable());
		// Do something while future gets completed.
		Integer result = null;
		Integer resultWithTimeout = null;
		try {
			result = future.get(); // Blocking operation.
			resultWithTimeout = future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {

			e.printStackTrace();
		}

		System.out.println(result);
		System.out.println(resultWithTimeout);

	}

	
}
