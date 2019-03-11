package djava.collections.performance;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapFactory {

	public static Map<Integer, Integer> get(String collectionType) {
		switch (collectionType) {

		case "LinkedHashMap":
			return new LinkedHashMap<Integer, Integer>();
			
		}

		return null;
	}

}
