package djava.concurrency.synchronization;

@SuppressWarnings("unused")
public class SellerThreadClass extends Thread {

	private TicketDataBase db;
	private String seller;
	private int salesGoal;

	public SellerThreadClass(TicketDataBase db, String seller, int salesGoal) {
		this.db = db;
		this.seller = seller;
		this.salesGoal = salesGoal;
	}

	public void run() {
		for (int i = 0; i < salesGoal; i++) {
			try {
				// Ticket ticket = nonSync(i);
//				Ticket ticket = syncMethod(i);
				Ticket ticket = syncBlock(i);
				if (ticket != null) {
					Thread.sleep(10); //Simulating PROCESSING time AFTER querying database.
					System.out.println("Ticket sold by " + seller + ": " + ticket);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private Ticket nonSync(int i) throws InterruptedException {
		return db.sell(seller, "buyer" + i);
	}

	private Ticket syncMethod(int i) throws InterruptedException {
		return db.sellSync(seller, "buyer" + i);
	}

	private Ticket syncBlock(int i) throws InterruptedException {
		synchronized (db) {
			return db.sell(seller, "buyer" + i);
		}

	}

}
