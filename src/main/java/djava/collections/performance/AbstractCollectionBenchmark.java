package djava.collections.performance;

import static djava.collections.performance.Collections.CopyOnWriteArrayList;
import static djava.collections.performance.Collections.CopyOnWriteArraySet;

import djava.collections.performance.Collections;

public abstract class AbstractCollectionBenchmark implements CollectionBenchmark {

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
		int times = 100;
		System.out.println(collectionType);
		System.out.println(executeOperations(collectionType, 1_000, times));
		System.out.println(executeOperations(collectionType, 1_000 * 10, times));
		System.out.println(executeOperations(collectionType, 1_000 * 100, times));
		System.out.println(executeOperations(collectionType, 1_000 * 1000, times));
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