package djava.collections.performance.benchmarks.map;

import static djava.collections.performance.MapFactory.get;

import djava.collections.performance.AbstractMapBenchmark;
import djava.collections.performance.MapType;

public class AddMapBenchmark extends AbstractMapBenchmark {
	@Override
	public void beforeOperation(MapType type, int size) {
		this.map = get(type);
	}

	@Override
	public void operation(MapType type, int size) {
		for (int i = 0; i < size; ++i) {
			map.put(i, i);
		}
	}

}
