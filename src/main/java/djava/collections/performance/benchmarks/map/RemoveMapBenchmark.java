package djava.collections.performance.benchmarks.map;

import static djava.collections.performance.MapFactory.get;

import djava.collections.performance.AbstractMapBenchmark;
import djava.collections.performance.MapType;

public class RemoveMapBenchmark extends AbstractMapBenchmark {

	@Override
	public void beforeOperation(MapType type, int size) {
		this.map = get(type, size);
	}

	@Override
	public void operation(MapType type, int size) {
		removeAsc(type, size);
//		removeDesc(type, size);
	}

	private void removeAsc(MapType type, int size) {
		for (int i = 0; i < size; ++i) {
			map.remove(i);
		}
	}

	@SuppressWarnings("unused")
	private void removeDesc(MapType type, int size) {
		for (int i = size; i > 0; --i) {
			map.remove(i);
		}
	}

}
