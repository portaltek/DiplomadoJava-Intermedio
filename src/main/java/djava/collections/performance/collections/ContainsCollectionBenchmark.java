package djava.collections.performance.collections;

import static djava.collections.util.CollectionFactory.get;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.util.CollectionType;

public class ContainsCollectionBenchmark extends AbstractCollectionBenchmark {

	@Override
	public void beforeOperation(CollectionType collectionType, int collectionSize) {
		collection = get(collectionType, collectionSize);
	}

	@Override
	public void operation(CollectionType collectionType, int collectionSize) {
		collection.contains(collectionSize - 1);
	}

}
