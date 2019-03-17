package djava.concurrency;

import djava.concurrency.multithreading.ClassExtendsThread;
import djava.concurrency.multithreading.ClassImplementsRunnable;
import djava.concurrency.synchronization.SellerThreadClass;
import djava.concurrency.synchronization.TicketDataBase;

public class CreatingThreads {

	public static void main(String[] args) throws InterruptedException {
		// Main thread
		System.out.println("Main Thread: start =======================");
		// runningParallelThreads();
		runningSyncronizedThreads();
		System.out.println("Main Thread: finish =======================");
	}

	public static void runningParallelThreads() {
		// ----------------Secondary/Child thread -------------------------------
		ClassImplementsRunnable cir = new ClassImplementsRunnable();
		Thread thread = new Thread(cir);// New status
		thread.start(); // Running status.

		// ----------------Secondary/Child thread -------------------------------
		ClassExtendsThread cet = new ClassExtendsThread(); // New status
		cet.start(); // Running status.
	}

	public static void runningSyncronizedThreads() throws InterruptedException {
		int salesGoal = 5;
		TicketDataBase db = new TicketDataBase(salesGoal);
		SellerThreadClass seller1 = new SellerThreadClass(db, "Seller1", salesGoal);
		SellerThreadClass seller2 = new SellerThreadClass(db, "Seller2", salesGoal);
		SellerThreadClass seller3 = new SellerThreadClass(db, "Seller3", salesGoal);

		seller1.start();
		// thread1.join(); //To join child thread into main/parent thread.
		seller2.start();
		seller3.start();

	}

}
