package djava.concurrency.multithreading;

//Use "extends Thread"  when you class IS NOT EXTENDING from other class already.
public class ClassExtendsThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("ClassExtendsThread: " + i);
				Thread.sleep(10L); //Simulating a long operation
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}
