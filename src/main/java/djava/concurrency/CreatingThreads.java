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
		//runningSyncronizedMultiThreads();
		runningPerformanceMultiVsSingleThreads();
		System.out.println("Main Thread: finish =======================");
	}

	public static void runningParallelThreads() {
		// ----------------Secondary/Child thread -------------------------------
		ClassImplementsRunnable cir = new ClassImplementsRunnable();
		Thread thread = new Thread(cir);// New status		
		thread.start(); // Runnable status & Running status.

		// ----------------Secondary/Child thread -------------------------------
		ClassExtendsThread cet = new ClassExtendsThread(); // New status
		cet.start(); // Runnable status & Running status.
	}

	public static Long runningSyncronizedMultiThreads() throws InterruptedException {
		int salesGoal = 8;
		TicketDataBase db = new TicketDataBase(salesGoal);
		SellerThreadClass seller1 = new SellerThreadClass(db, "Seller1", salesGoal);
		SellerThreadClass seller2 = new SellerThreadClass(db, "Seller2", salesGoal);
		SellerThreadClass seller3 = new SellerThreadClass(db, "Seller3", salesGoal);
		SellerThreadClass seller4 = new SellerThreadClass(db, "Seller4", salesGoal);
//		seller1.setPriority(Thread.MIN_PRIORITY);
//		seller2.setPriority(Thread.MIN_PRIORITY);
//		seller3.setPriority(Thread.MIN_PRIORITY);
//		seller4.setPriority(Thread.MAX_PRIORITY);
		
		
		Long startTime = System.nanoTime();
		seller1.start();
		seller2.start();
		seller3.start();
		seller4.start();
		seller1.join();
		seller2.join();
		seller3.join();
		seller4.join();
		Long endTime = System.nanoTime();
		Long duration = endTime - startTime;
		//System.out.println("Duration: " + duration); 
		return duration;
	
	}
	
	public static Long runningSingleThread() throws InterruptedException {
		int salesGoal = 8;
		TicketDataBase db = new TicketDataBase(salesGoal);
		SellerThreadClass seller1 = new SellerThreadClass(db, "Seller1", salesGoal);
		
		Long startTime = System.nanoTime();
		seller1.start();
		seller1.join();
	
		Long endTime = System.nanoTime();
		Long duration = endTime - startTime;
		return duration;
	}
	
	public static void runningPerformanceMultiVsSingleThreads() throws InterruptedException {
		Long multiThreadAcumulatedDuration = 0L;
		Long singleThreadAcumulatedDuration = 0L;
		int times = 30;
		for (int i = 0; i < times; i++) {
			multiThreadAcumulatedDuration += runningSyncronizedMultiThreads();
		}
		for (int i = 0; i < times; i++) {
			singleThreadAcumulatedDuration += runningSingleThread();
		}
		
		System.out.println("Multi thread :\t" + (multiThreadAcumulatedDuration/times));
		System.out.println("Single thread:\t" + (singleThreadAcumulatedDuration/times));
		
	}

}
