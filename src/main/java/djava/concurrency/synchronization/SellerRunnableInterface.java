package djava.concurrency.synchronization;

public class SellerRunnableInterface implements Runnable {
	private TicketDataBase db;

	public SellerRunnableInterface(TicketDataBase db) {
		this.db = db;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			Ticket t;
			try {
				t = db.sell("SellerRunnableInterface", "buyer" + i);
				if (t != null) {
					System.out.println("Ticket sold: " + t);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
