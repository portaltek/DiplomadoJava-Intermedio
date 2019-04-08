package djava.functionalinterfaces;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//boolean test(T t)
public class FunctionalInterfacePredicate {
	public static void main(String[] args) {
		Map<String, Integer> iqMap = new ConcurrentHashMap<>();
		iqMap.put("Larry", 100);
		iqMap.put("Curly", 90);
		iqMap.put("Moe", 110);

		System.out.println(iqMap);
		iqMap.entrySet().removeIf(e -> e.getValue() <= 100);
		System.out.println(iqMap);
	}
}
