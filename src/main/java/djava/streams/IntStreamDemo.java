package djava.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamDemo {
	public final static int[] NUMBERS = { 1, 2, 3, 4, 5, 6, 7 };

	public static void main(String[] args) {
		IntStreamDemo s = new IntStreamDemo();
//		s.getMinWithForLoop();
//		s.getMinWithStream();
		s.getMin3WithForLoop();
		s.getMin3WithStream();

	}

	public void getMin3WithStream() {

		IntStream.of(NUMBERS).distinct().sorted().limit(3).forEach(System.out::println);
	}

	public void getMin3WithForLoop() {

		int[] copy = Arrays.copyOf(NUMBERS, NUMBERS.length);
		Arrays.sort(copy);
		for (int i = 0; i < 3; i++) {
			System.out.println(copy[i]);
		}

	}

	public void getMinWithStream() {

		int min = IntStream.of(NUMBERS).min().getAsInt();
		int min2 = IntStream.of(NUMBERS).summaryStatistics().getMin();
		System.out.println("min=" + min);
		System.out.println("min2=" + min2);
	}

	public void getMinWithForLoop() {

		int min = NUMBERS[0];
		for (int i = 0; i < NUMBERS.length; i++) {
			if (min > NUMBERS[i]) {
				min = NUMBERS[i];
			}
		}
		System.out.println("min=" + min);
	}

}
