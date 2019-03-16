package djava.collections.performance;

import java.util.Map;

public abstract class AbstractMapBenchmark implements MapBenchmark {

	protected int times = 50;
	protected int size1 = 1_000;
	protected int size2 = 10_000;
	protected int size3 = 100_000;
	protected int size4 = 1_000_000;
	protected Map<Integer, Integer> map;

	public abstract void beforeOperation(MapType type, int size);

	public abstract void operation(MapType type, int size);

	@Override
	public double executeOperations(MapType type, int size, int times) {
		Long acumulatedDuration = 0L;
		for (int i = 0; i < times; i++) {
			beforeOperation(type, size);
			Long startTime = System.nanoTime();
			operation(type, size);
			Long endTime = System.nanoTime();
			acumulatedDuration += endTime - startTime;
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
			
			execute(c);
		}
		System.out.println("END");
	}

}