package djava.collections.performance;

import static djava.collections.performance.Collections.CopyOnWriteArrayList;
import static djava.collections.performance.Collections.CopyOnWriteArraySet;

import djava.collections.performance.Collections;

public abstract class AbstractCollectionBenchmark implements CollectionBenchmark {
	
	protected int times = 100;
	protected int size1 = 1_000;
	protected int size2 = 10_000;
	protected int size3 = 100_000;
	protected int size4 = 1_000_000;
	
	
	public AbstractCollectionBenchmark() {
		super();
	}
	
	@Override
	public abstract Long operation(Collections collectionType, int collectionSize) ;

	@Override
	public double executeOperations(Collections collectionType, int collectionSize, int times) {
		Long acumulatedDuration = 0L;
		for (int i = 0; i < times; i++) {
			Long duration = operation(collectionType, collectionSize);
			acumulatedDuration += duration;
			// System.out.println(collectionSize + "\t" + duration);
		}
		return (double) acumulatedDuration / (double) times;
	}

	@Override
	public void execute(Collections collectionType) {
	
		System.out.println(collectionType);
		System.out.println(executeOperations(collectionType, size1, times));
		System.out.println(executeOperations(collectionType, size2, times));
		System.out.println(executeOperations(collectionType, size3, times));
		System.out.println(executeOperations(collectionType, size4, times));
	}

	@Override
	public void executeAll() {
		Collections[] collections = Collections.values();
		for (Collections c : collections) {
			if (CopyOnWriteArrayList.equals(c) || CopyOnWriteArraySet.equals(c)) {
				continue;
			}
			execute(c);
		}
		System.out.println("END");
	}

}