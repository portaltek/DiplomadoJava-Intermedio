package djava.collections.util;

import java.util.Collection;
import java.util.Map;

public class Printer {
	public void printForEach(Collection<?> collection) {
		collection.forEach(System.out::println);
	}

	public void printForEach2(Collection<?> collection) {
		collection.forEach(e -> {
			System.out.println(e);
		});
	}

	public void printFor(Collection<?> collection) {
		for (Object e : collection) {
			System.out.println(e);
		}

	}
	
	public void printMap(Map<?,?> map) {
		System.out.println(map);
	}
}
