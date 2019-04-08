package djava.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//R apply(T t)
public class FunctionalInterfaceFunction {
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>(
				Arrays.asList(new Thread("Larry"), new Thread("Curly"), new Thread("Moe")));

		threads.forEach(System.out::println);
		threads.sort(Comparator.comparing(Thread::getName));
		threads.forEach(System.out::println);
	}

}
