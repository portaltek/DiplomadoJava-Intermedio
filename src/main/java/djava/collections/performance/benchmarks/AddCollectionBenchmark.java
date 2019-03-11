package djava.collections.performance.benchmarks;

import java.util.Collection;

import djava.collections.performance.CollectionFactory;
import djava.collections.performance.Collections;

public class AddCollectionBenchmark extends AbstractCollectionBenchmark {

	@Override
	public Long operation(Collections collectionType, int collectionSize) {
		Collection<Integer> collection = CollectionFactory.get(collectionType);
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < collectionSize; ++i) {
			collection.add(i);
		}
		Long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
