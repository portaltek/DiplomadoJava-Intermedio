package djava.collections.performance.benchmarks;

import static djava.collections.performance.CollectionFactory.get;

import djava.collections.performance.AbstractCollectionBenchmark;
import djava.collections.performance.CollectionType;

public class RemoveCollectionBenchmark extends AbstractCollectionBenchmark {

	{
		times = 10;
		size1 = 100;
		size2 = 1000;
		size3 = 1_0000;
		size4 = 10_0000;
	}

	@Override
	public void beforeOperation(CollectionType collectionType, int collectionSize) {
		collection = get(collectionType, collectionSize);
	}

	@Override
	public void operation(CollectionType collectionType, int collectionSize) {
		// ASC
//		for (int i = 0; i < collectionSize; ++i) {
//			collection.remove(i);
//		}
		// DESC
		for (int i = collectionSize; i > 0; --i) {
			collection.remove(i);
		}
	}

}
