package djava.collections.performance.benchmarks;

import static djava.collections.performance.CollectionFactory.get;

import java.util.Collection;

import djava.collections.performance.Collections;

public class RemoveCollectionBenchmark extends AbstractCollectionBenchmark {

	public Long operation(Collections collectionType, int collectionSize) {

		Collection<Integer> collection = get(collectionType, collectionSize);
		Long startTime = System.currentTimeMillis();		
		for (int i = 0; i < collectionSize; ++i) {
			collection.remove(i);
		}
		Long endTime = System.currentTimeMillis();
		return endTime - startTime;

	}

}
