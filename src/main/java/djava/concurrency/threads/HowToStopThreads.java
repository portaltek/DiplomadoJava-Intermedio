package djava.concurrency.threads;

public class HowToStopThreads {
	public static void main(String[] args) {
		HowToStopThreads howToStopThreads = new HowToStopThreads();
		howToStopThreads.stopThread();

	}

	public void stopThread() {
		Thread t1 = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("Stopping task as requested.");
				return;
			}
		});
		t1.start();
		t1.interrupt();

	}

}
