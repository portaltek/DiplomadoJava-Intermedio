package djava.concurrency.synchronization;

public class Ticket {
	private int id;
	private double price;
	private String status;
	private String seller;
	private String buyer;

	public Ticket(int id, double price, String status) {
		super();
		this.id = id;
		this.price = price;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	@Override
	public String toString() {
		return "[id=" + id +  ", seller=" + seller + "]";
	}

}