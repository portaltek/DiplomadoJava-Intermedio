package djava.concurrency.threads;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
	public static void main(String[] args) throws InterruptedException {
		ThreadLocalDemo t = new ThreadLocalDemo();
//		t.test();
//		t.testExecutorService();
		t.testExecutorService2();
	}

	// Low performance 100 Threads get created
	public void test() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			final int id = i;
			new Thread(() -> {
				String birthDate = new UserService().birthDate(id);
				System.out.println(birthDate);
			}).start();

		}
		Thread.sleep(1000);
	}

	// Better performance only 4 Threads get created
	public void testExecutorService() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			final int id = i;
			Thread t = new Thread(() -> {
				String birthDate = new UserService().birthDate(id);
				System.out.println(birthDate);
			});
			service.submit(t);

		}
		Thread.sleep(1000);
	}

	// Better performance only 4 Threads get created
	public void testExecutorService2() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			final int id = i;
			Thread t = new Thread(() -> {
				String birthDate = new UserService2().birthDate(id);
				System.out.println(birthDate);
			});
			service.submit(t);

		}
		Thread.sleep(1000);
	}

	private static class UserService {
		private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		public String birthDate(int userId) {
			LocalDate date = LocalDate.now().plusDays(userId);
			return date.format(formatter);
		}
	}

	private static class UserService2 {

		public String birthDate(int userId) {
			LocalDate date = LocalDate.now().plusDays(userId);
			return date.format(ThreadSafeFormatter.df.get());
		}
	}

}

class ThreadSafeFormatter {

	private ThreadSafeFormatter() {

	}

	public static ThreadLocal<DateTimeFormatter> df = new ThreadLocal<DateTimeFormatter>() {
		@Override
		protected DateTimeFormatter initialValue() {
			System.out.println(Thread.currentThread().getName());
			return DateTimeFormatter.ofPattern("yyyy-MM-dd");
		}

		@Override
		public DateTimeFormatter get() {
//			System.out.println(Thread.currentThread().getName());
			return super.get();
		}
	};

	public static ThreadLocal<DateTimeFormatter> df2 = ThreadLocal
			.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd"));
}
