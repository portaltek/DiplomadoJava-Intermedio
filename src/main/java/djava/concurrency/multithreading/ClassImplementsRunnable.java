package djava.concurrency.multithreading;

//Use "implements Runnable" when you class IS EXTENDING from other class already.
public class ClassImplementsRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("ClassImplementsRunnable: " + i);
				Thread.sleep(10L); //Simulating a long operation
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
