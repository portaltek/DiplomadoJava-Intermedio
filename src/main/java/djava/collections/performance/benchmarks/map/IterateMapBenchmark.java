package djava.collections.performance.benchmarks.map;

import static djava.collections.performance.MapFactory.get;

import java.util.Map.Entry;

import djava.collections.performance.AbstractMapBenchmark;
import djava.collections.performance.MapType;

public class IterateMapBenchmark extends AbstractMapBenchmark {

	@Override
	public void beforeOperation(MapType type, int size) {
		this.map = get(type, size);
	}

	@SuppressWarnings("unused")
	@Override
	public void operation(MapType type, int size) {

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
		    //System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}

}
