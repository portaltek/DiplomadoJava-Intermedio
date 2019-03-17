package djava.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import djava.collections.util.Printer;

public class BasicCollectionInterfaces {
	
	public void initInterfaces() {
		Collection<Short> shortCollection = new ArrayList<>();
		Set<Integer> integerCollection = new HashSet<>();
		List<Float> floatCollection = new ArrayList<>();
		Queue<Double> doubleCollection = new PriorityQueue<>();
		Map<Long, String> longMap = new HashMap<>();

		shortCollection.add((short) 1);
		shortCollection.add((short) 2);
		shortCollection.add((short) 3);

		integerCollection.add(4); // Casting is optional for integers
		integerCollection.add((int) 5);
		integerCollection.add((int) 6);

		floatCollection.add((float) 7);
		floatCollection.add(8F);
		floatCollection.add(9.9F);

		doubleCollection.add((double) 10);
		doubleCollection.add(11D);
		doubleCollection.add(12.0);
		
		
		

		longMap.put(13L, "13 value");
		longMap.put((long) 14, "14 value");
		longMap.put(15L, "15 value");

		Printer p = new Printer();
		p.printFor(shortCollection);
		p.printForEach(integerCollection);
		p.printForEach2(floatCollection);
		p.printFor(doubleCollection);
		p.printMap(longMap);
	}

}
