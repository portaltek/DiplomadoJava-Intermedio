package djava.collections.basicCollectionInterfaces;

import static djava.collections.util.MapFactory.allowsNullKey;
import static djava.collections.util.MapFactory.allowsNullValue;

import java.util.Map;

import djava.collections.util.MapFactory;
import djava.collections.util.MapType;

public class NullableCollectionsAndMaps {

	public static void main(String... args) {

		MapType[] maps = MapType.values();
		for (MapType c : maps) {
			System.out.println(c);
			Map<Integer, Integer> map = MapFactory.get(c);
			if (allowsNullKey(c) && allowsNullValue(c)) {
				map.put(null, null);
			} else if (allowsNullValue(c)) {
				map.put(1, null);
			} else {
				map.put(1, 1);
			}

			System.out.println(map);
		}
	}

}
