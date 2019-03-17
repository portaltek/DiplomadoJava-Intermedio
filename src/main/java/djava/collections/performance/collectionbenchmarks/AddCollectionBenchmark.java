package djava.collections.performance.collectionbenchmarks;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.util.CollectionFactory;
import djava.collections.util.CollectionType;

public class AddCollectionBenchmark extends AbstractCollectionBenchmark {

	@Override
	public void beforeOperation(CollectionType collectionType, int collectionSize) {
		collection = CollectionFactory.get(collectionType);
	}

	@Override
	public void operation(CollectionType collectionType, int collectionSize) {
		for (int i = 0; i < collectionSize; ++i) {
			collection.add(i);
		}
	}

}
