package djava.collections.performance.benchmarks;

import static djava.collections.performance.CollectionFactory.get;

import java.util.Collection;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.performance.Collections;

public class RemoveCollectionBenchmark extends AbstractCollectionBenchmark {

	{
		times = 10;
		size1 = 100;
		size2 = 1000;
		size3 = 1_0000;
		size4 = 10_0000;
	}

	public Long operation(Collections collectionType, int collectionSize) {

		Collection<Integer> collection = get(collectionType, collectionSize);
		Long startTime = System.currentTimeMillis();
		// ASC
//		for (int i = 0; i < collectionSize; ++i) {
//			collection.remove(i);
//		}
		// DESC
		for (int i = collectionSize; i > 0; --i) {
			collection.remove(i);			
		}
		Long endTime = System.currentTimeMillis();
		return endTime - startTime;

	}

}
