package djava.concurrency.threads;

import java.util.concurrent.RecursiveTask;

public class ForkJoiningPool {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Fibonacci f = new Fibonacci(i);
			System.out.println(f.compute());
		}

	}

	private static class Fibonacci extends RecursiveTask<Integer> {

		private static final long serialVersionUID = 1L;
		final int n;

		public Fibonacci(int n) {
			this.n = n;
		}

		@Override
		protected Integer compute() {
			if (n <= 1) {
				return n;
			}
			Fibonacci f1 = new Fibonacci(n - 1);
			f1.fork();
			Fibonacci f2 = new Fibonacci(n - 2);
			f2.fork();
			return f2.join() + f1.join();
		}

	}
}
