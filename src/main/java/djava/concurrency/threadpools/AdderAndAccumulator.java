package djava.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AdderAndAccumulator {

	public static void main(String[] args) throws InterruptedException {
		AdderAndAccumulator a = new AdderAndAccumulator();
		a.testLongAccumulator();
	}

	public void testAtomicLong() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(16);

		AtomicLong counter = new AtomicLong(0);
		for (int i = 0; i < 100; i++) {
			service.submit(new AtomicLongTask(counter));
		}
		Thread.sleep(2000);
		System.out.println(counter.get());
	}

	public void testLongAdder() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(16);
		LongAdder counter = new LongAdder();
		for (int i = 0; i < 100; i++) {
			service.submit(new LongAdderTask(counter));
		}
		Thread.sleep(2000);
		System.out.println(counter.sum());
	}

	public void testLongAccumulator() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(16);
		LongAccumulator counter = new LongAccumulator((newValue, oldValue) -> newValue + oldValue, 0);
		for (int i = 0; i < 100; i++) {
			service.submit(new LongAccumulatorTask(counter));
		}
		Thread.sleep(2000);
		System.out.println(counter.get());
	}

	private static class AtomicLongTask implements Runnable {

		private final AtomicLong counter;

		public AtomicLongTask(AtomicLong counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			counter.incrementAndGet();
		}

	}

	private static class LongAdderTask implements Runnable {

		private final LongAdder counter;

		public LongAdderTask(LongAdder counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			counter.increment();
		}

	}

	private static class LongAccumulatorTask implements Runnable {

		private final LongAccumulator counter;

		public LongAccumulatorTask(LongAccumulator counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			counter.accumulate(1);
		}

	}
}
