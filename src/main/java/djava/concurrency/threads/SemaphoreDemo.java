package djava.concurrency.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreDemo {
	public static void main(String[] args) {
		SemaphoreDemo sd = new SemaphoreDemo();
		sd.test();
	}

	public void test() {

		try {
			Semaphore semaphore = new Semaphore(2);
			ExecutorService service = Executors.newFixedThreadPool(4);
			IntStream.of(1, 2, 3, 4, 5, 6).forEach(i -> service.execute(new Task(i, semaphore)));
			service.shutdown();
			service.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class Task implements Runnable {
		private int taskId;
		private Semaphore semaphore;

		public Task(int taskId, Semaphore semaphore) {
			super();
			this.taskId = taskId;
			this.semaphore = semaphore;
		}

		public void run() {
			try {
				System.out.println("semaphore.availablePermits(): " + semaphore.availablePermits());
				semaphore.acquire();
				semaphore.release();
				System.out.println(Thread.currentThread().getName() + " taskId: " + taskId);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
