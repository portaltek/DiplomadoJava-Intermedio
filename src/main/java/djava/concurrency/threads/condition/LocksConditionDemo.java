package djava.concurrency.threads.condition;

public class LocksConditionDemo {
	public static void main(String[] args) throws InterruptedException {
		FileReaderQueue sharedQueue = new FileReaderQueue(3);

		// Create a producer and a consumer.
		Thread producer = new FileReaderProducer(sharedQueue);
		Thread consumer = new FileReaderConsumer(sharedQueue);

		// Start both threads.
		producer.start();
		consumer.start();

		// Wait for both threads to terminate.
		producer.join();
		consumer.join();
	}
}
