package djava.concurrency.threads.condition;

import java.util.HashSet;
import java.util.Set;

public class FileReaderConsumer extends Thread {
	private final Set<Object> seenObjects = new HashSet<>();
	private int total = 0;
	private final FileReaderQueue queue;

	public FileReaderConsumer(FileReaderQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Object obj = queue.remove();
				if (obj == null)
					break; // Out condition

				if (!seenObjects.contains(obj)) {
					++total;
					seenObjects.add(obj);
				}

				System.out.println("[Consumer] Read the element: " + obj.toString());

			}
		} catch (InterruptedException ex) {
			System.err.println("An InterruptedException was caught: " + ex.getMessage());
			ex.printStackTrace();
		}

		System.out.println("\n[Consumer] " + total + " distinct words have been read...");
	}
}