package djava.collections.performance.collectionbenchmarks;

import static djava.collections.util.CollectionFactory.get;

import java.util.Iterator;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.util.CollectionType;

public class IterateCollectionBenchmark extends AbstractCollectionBenchmark {

	@Override
	public void beforeOperation(CollectionType collectionType, int collectionSize) {
		collection = get(collectionType, collectionSize);
	}

	@SuppressWarnings("unused")
	@Override
	public void operation(CollectionType collectionType, int collectionSize) {
		for (Iterator<Integer> iterator = collection.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
		}
	}

}
