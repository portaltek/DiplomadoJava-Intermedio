package djava.lambdas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LambdaDemo {
	public static void main(String[] args) {
		Runnable printThreadName = () -> System.out.println("Thread: " + Thread.currentThread().getName());
		Callable<Integer> printInteger = () -> {
			System.out.println("Integer: " + 5);
			return 5;
		};
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(printThreadName);
		executor.submit(printInteger);
	}
}
