package djava.collections.performance;



import static djava.collections.performance.CollectionFactory.skip;

import java.util.Collection;

import djava.collections.performance.CollectionType;

public abstract class AbstractCollectionBenchmark implements CollectionBenchmark {

	protected int times = 50;
	protected int size1 = 1_000;
	protected int size2 = 10_000;
	protected int size3 = 100_000;
	protected int size4 = 1_000_000;
	protected Collection<Integer> collection;
	

	public abstract void beforeOperation(CollectionType collectionType, int collectionSize);

	public abstract void operation(CollectionType collectionType, int collectionSize);


	public double executeOperations(CollectionType collectionType, int collectionSize, int times) {
		Long acumulatedDuration = 0L;
		for (int i = 0; i < times; i++) {
			beforeOperation(collectionType, collectionSize);
			Long startTime = System.nanoTime();
			operation(collectionType, collectionSize);
			Long endTime = System.nanoTime();
			acumulatedDuration += endTime - startTime;
		}
		return (double) acumulatedDuration / (double) times;
	}


	public void execute(CollectionType collectionType) {

		System.out.println(collectionType);
		System.out.println(executeOperations(collectionType, size1, times));
		System.out.println(executeOperations(collectionType, size2, times));
		System.out.println(executeOperations(collectionType, size3, times));
		System.out.println(executeOperations(collectionType, size4, times));
	}

	public void executeAll() {
		CollectionType[] collections = CollectionType.values();
		for (CollectionType c : collections) {
			if (skip(c)) {
				continue;
			}
			execute(c);
		}
		System.out.println("END");
	}

}