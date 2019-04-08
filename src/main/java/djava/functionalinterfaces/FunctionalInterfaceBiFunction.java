package djava.functionalinterfaces;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//R apply(T t, U u)
public class FunctionalInterfaceBiFunction {
	public static void main(String[] args) {
		Map<String, Integer> iqMap = new ConcurrentHashMap<String, Integer>() {
			{
				put("Larry", 100);
				put("Curly", 90);
				put("Moe", 110);
			}
		};

		iqMap.replaceAll((k, v) -> v - 50);
		System.out.println(iqMap);
	}

}
