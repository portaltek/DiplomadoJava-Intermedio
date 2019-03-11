package djava.collections.performance.benchmarks;

import static djava.collections.performance.CollectionFactory.get;

import java.util.Collection;
import java.util.Iterator;

import djava.collections.performance.Collections;

public class IterateCollectionBenchmark extends AbstractCollectionBenchmark {

	public Long operation(Collections collectionType, int collectionSize) {

		Collection<Integer> collection = get(collectionType, collectionSize);
		Long startTime = System.currentTimeMillis();
		for (Iterator<Integer> iterator = collection.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();

		}
		Long endTime = System.currentTimeMillis();
		return endTime - startTime;

	}

}
