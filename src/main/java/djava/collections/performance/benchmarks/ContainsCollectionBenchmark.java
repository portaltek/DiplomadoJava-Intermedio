package djava.collections.performance.benchmarks;

import static djava.collections.performance.CollectionFactory.get;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.performance.CollectionType;

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
