package djava.collections.performance.benchmarks;

import static djava.collections.performance.CollectionFactory.get;

import java.util.Collection;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.performance.Collections;
public class ContainsCollectionBenchmark extends AbstractCollectionBenchmark {

	public Long operation(Collections collectionType, int collectionSize) {

		Collection<Integer> collection = get(collectionType, collectionSize);
		Long startTime = System.currentTimeMillis();
		collection.contains(collectionSize - 1);
		Long endTime = System.currentTimeMillis();
		return endTime - startTime;

	}

}
