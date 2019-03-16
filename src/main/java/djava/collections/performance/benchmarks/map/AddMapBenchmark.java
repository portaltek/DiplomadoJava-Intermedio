package djava.collections.performance.benchmarks.map;

import java.util.Map;

import djava.collections.performance.AbstractMapBenchmark;
import djava.collections.performance.MapFactory;
import djava.collections.performance.MapType;

public class AddMapBenchmark extends AbstractMapBenchmark {

	@Override
	public Long operation(MapType type, int size) {
		Map<Integer, Integer> map = MapFactory.get(type);
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; ++i) {
			map.put(i, i);
		}
		Long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
