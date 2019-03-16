package djava.collections.performance.benchmarks.map;

import static djava.collections.performance.MapFactory.get;

import djava.collections.performance.AbstractMapBenchmark;
import djava.collections.performance.MapType;

public class GetMapBenchmark extends AbstractMapBenchmark {
	
	

	@Override
	public void beforeOperation(MapType type, int size) {
		this.map = get(type, size);
	}

	@Override
	public void operation(MapType type, int size) {
		getFromHead1(type, size);
//		getFromRearMinus1(type, size);
	}
	
	@SuppressWarnings("unused")
	private void getFromRearMinus1(MapType type, int size) {
		map.get(size - 1);
	}
	
	private void getFromHead1(MapType type, int size) {
		map.get(1);
	}

}
