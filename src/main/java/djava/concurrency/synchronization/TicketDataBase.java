package djava.concurrency.synchronization;

import java.util.ArrayList;
import java.util.List;

public class TicketDataBase {

	List<Ticket> ticketList = new ArrayList<>();

	public TicketDataBase(int quantity) {
		init(quantity);
	}

	private void init(int quantity) {
		for (int i = 0; i < quantity; i++) {
			ticketList.add(new Ticket(i, 100, "available"));
		}
	}

	synchronized public Ticket sellSync(String seller, String buyer) throws InterruptedException {
		return sell(seller, buyer);
	}

	public Ticket sell(String seller, String buyer) throws InterruptedException {
		for (Ticket ticket : ticketList) {
			if ("available".equals(ticket.getStatus())) {
				//Thread.sleep(10); //Simulating time to query actual database.
				ticket.setStatus("sold");
				ticket.setSeller(seller);
				ticket.setBuyer(buyer);
				return ticket;
			}
		}
		return null;
	}

}
