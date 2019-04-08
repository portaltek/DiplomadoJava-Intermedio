package djava.collections.performance.maps;

import static djava.collections.util.MapFactory.get;

import djava.collections.performance.AbstractMapBenchmark;
import djava.collections.util.MapType;

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
