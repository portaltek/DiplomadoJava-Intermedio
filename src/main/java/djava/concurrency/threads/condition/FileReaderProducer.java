package djava.concurrency.threads.condition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderProducer extends Thread {
	private static final String FILENAME = "input.txt";
	private final FileReaderQueue queue;

	public FileReaderProducer(FileReaderQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		try (BufferedReader rd = new BufferedReader(new FileReader(FILENAME))) {

			String inputLine = null;
			while ((inputLine = rd.readLine()) != null) {
				String[] inputWords = inputLine.split(" ");
				for (String inputWord : inputWords) {
					queue.add(inputWord);
				}
			}

			// Terminate the execution.
			queue.add(null);
		} catch (InterruptedException ex) {
			System.err.println("An InterruptedException was caught: " + ex.getMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.err.println("An IOException was caught: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
