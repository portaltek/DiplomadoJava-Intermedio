package djava.concurrency.threads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScatterGatherPattern {
	public static void main(String[] args) {
		ScatterGatherPattern scatterGatherPattern = new ScatterGatherPattern();
//		producerConsumerPattern.testWithBlockingQueue();
		scatterGatherPattern.getPricesCompletableFuture();
	}

	ExecutorService threadPool = Executors.newFixedThreadPool(4);
	CountDownLatch latch = new CountDownLatch(3);

	private Set<Integer> getPrices() {
		Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
		threadPool.submit(new Task("url1", 1, prices, latch));
		threadPool.submit(new Task("url2", 1, prices, latch));
		threadPool.submit(new Task("url3", 1, prices, latch));

//		Thread.sleep(3, 1000); // Not efficient if ALL task complete under 3 secs.
		try {
			latch.await(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return prices;
	}

	private Set<Integer> getPricesCompletableFuture() {
		Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

		CompletableFuture<Void> task1 = CompletableFuture.runAsync(new TaskCompletableFuture("url1", 1, prices));
		CompletableFuture<Void> task2 = CompletableFuture.runAsync(new TaskCompletableFuture("url2", 1, prices));
		CompletableFuture<Void> task3 = CompletableFuture.runAsync(new TaskCompletableFuture("url3", 1, prices));
		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
		try {
			allTasks.get(3, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		return prices;
	}

	private static class Task implements Runnable {
		private String url;
		private int productId;
		private Set<Integer> prices;
		private CountDownLatch latch;

		public Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
			super();
			this.url = url;
			this.productId = productId;
			this.prices = prices;
			this.latch = latch;
		}

		@Override
		public void run() {
			int price = 0;
			// make http call to get price
			prices.add(price);
			latch.countDown();
		}

	}

	private static class TaskCompletableFuture implements Runnable {
		private String url;
		private int productId;
		private Set<Integer> prices;

		public TaskCompletableFuture(String url, int productId, Set<Integer> prices) {

			this.url = url;
			this.productId = productId;
			this.prices = prices;

		}

		@Override
		public void run() {
			int price = 0;
			// make http call to get price
			prices.add(price);

		}

	}

}
