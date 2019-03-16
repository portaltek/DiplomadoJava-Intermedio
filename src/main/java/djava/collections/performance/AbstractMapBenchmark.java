package djava.collections.performance;

import static djava.collections.performance.Collections.CopyOnWriteArrayList;
import static djava.collections.performance.Collections.CopyOnWriteArraySet;

public abstract class AbstractMapBenchmark implements MapBenchmark {

	protected int times = 100;
	protected int size1 = 1_000;
	protected int size2 = 10_000;
	protected int size3 = 100_000;
	protected int size4 = 1_000_000;

	public AbstractMapBenchmark() {
		super();
	}

	@Override
	public abstract Long operation(MapType type, int collectionSize);

	@Override
	public double executeOperations(MapType type, int collectionSize, int times) {
		Long acumulatedDuration = 0L;
		for (int i = 0; i < times; i++) {
			Long duration = operation(type, collectionSize);
			acumulatedDuration += duration;
			// System.out.println(collectionSize + "\t" + duration);
		}
		return (double) acumulatedDuration / (double) times;
	}

	@Override
	public void execute(MapType type) {

		System.out.println(type);
		System.out.println(executeOperations(type, size1, times));
		System.out.println(executeOperations(type, size2, times));
		System.out.println(executeOperations(type, size3, times));
		System.out.println(executeOperations(type, size4, times));
	}

	@Override
	public void executeAll() {
		MapType[] maps = MapType.values();
		for (MapType c : maps) {
			if (CopyOnWriteArrayList.equals(c) || CopyOnWriteArraySet.equals(c)) {
				continue;
			}
			execute(c);
		}
		System.out.println("END");
	}

}