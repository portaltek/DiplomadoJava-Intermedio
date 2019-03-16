package djava.collections.performance.benchmarks;

import static djava.collections.performance.CollectionFactory.get;

import java.util.Iterator;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.performance.CollectionType;

public class IterateCollectionBenchmark extends AbstractCollectionBenchmark {

	@Override
	public void beforeOperation(CollectionType collectionType, int collectionSize) {
		collection = get(collectionType, collectionSize);
	}

	@Override
	public void operation(CollectionType collectionType, int collectionSize) {
		for (Iterator<Integer> iterator = collection.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
		}
	}

}
