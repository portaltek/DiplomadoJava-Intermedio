package djava.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//void accept(T t)
public class FunctionalInterfaceConsumer {
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>(
				Arrays.asList(new Thread("Larry"), new Thread("Curly"), new Thread("Moe")));

		threads.forEach(System.out::println);
		threads.sort(Comparator.comparing(Thread::getName));
		threads.forEach(System.out::println);
	}

}
