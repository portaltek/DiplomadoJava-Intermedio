package djava.collections.performance;

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
