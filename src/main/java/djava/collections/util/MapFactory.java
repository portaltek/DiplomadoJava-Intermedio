package djava.collections.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapFactory {

	public static Map<Integer, Integer> get(MapType mapType, int size) {
		Map<Integer, Integer> map = get(mapType);
		for (int i = 0; i < size; ++i) {
			map.put(i, i);
		}
		return map;
	}

	public static boolean allowsNullKey(MapType mapType) {
		switch (mapType) {
		case TreeMap:
			return false;
		case Hashtable:
			return false;
		case ConcurrentHashMap:
			return false;
		case ConcurrentSkipListMap:
			return false;
		default:
			break;
		}
		return true;
	}

	public static boolean allowsNullValue(MapType mapType) {
		switch (mapType) {
		case Hashtable:
			return false;
		case ConcurrentHashMap:
			return false;
		case ConcurrentSkipListMap:
			return false;
		default:
			break;
		}
		return true;
	}

	public static Map<Integer, Integer> get(MapType mapType) {
		switch (mapType) {
		case HashMap:
			return new HashMap<Integer, Integer>();
		case LinkedHashMap:
			return new LinkedHashMap<Integer, Integer>();
		case TreeMap:
			return new TreeMap<Integer, Integer>();
		case IdentityHashMap:
			return new IdentityHashMap<Integer, Integer>();
		case WeakHashMap:
			return new WeakHashMap<Integer, Integer>();
		case Hashtable:
			return new Hashtable<Integer, Integer>();
		case ConcurrentHashMap:
			return new ConcurrentHashMap<Integer, Integer>();
		case ConcurrentSkipListMap:
			return new ConcurrentSkipListMap<Integer, Integer>();
		default:
			break;

		}

		return null;
	}

}
