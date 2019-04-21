package djava.concurrency.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		CountDownLatch latch = new CountDownLatch(3);
		executor.submit(new DependentService(latch));
		executor.submit(new DependentService(latch));
		executor.submit(new DependentService(latch));

		latch.await();

		System.out.println("All dependant services initialized");

	}

	public static class DependentService implements Runnable {

		private CountDownLatch latch;

		public DependentService(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			latch.countDown();
		}
	}
}
