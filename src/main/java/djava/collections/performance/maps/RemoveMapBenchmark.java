package djava.collections.performance.maps;

import static djava.collections.util.MapFactory.get;

import djava.collections.performance.AbstractMapBenchmark;
import djava.collections.util.MapType;

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
