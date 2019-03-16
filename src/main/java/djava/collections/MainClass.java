package djava.collections;

import djava.collections.performance.CollectionBenchmark;
import djava.collections.performance.Collections.*;
import djava.collections.performance.MapBenchmark;
import djava.collections.performance.benchmarks.AddCollectionBenchmark;
import djava.collections.performance.benchmarks.ContainsCollectionBenchmark;
import djava.collections.performance.benchmarks.IterateCollectionBenchmark;
import djava.collections.performance.benchmarks.RemoveCollectionBenchmark;
import djava.collections.performance.benchmarks.map.AddMapBenchmark;

public class MainClass {
	private static CollectionBenchmark iterateBenchmark = new IterateCollectionBenchmark();
	private static CollectionBenchmark addBenchmark = new AddCollectionBenchmark();
	private static CollectionBenchmark containsBenchmark = new ContainsCollectionBenchmark();
	private static CollectionBenchmark removeBenchmark = new RemoveCollectionBenchmark();
	private static MapBenchmark addMB = new AddMapBenchmark();

	public static void main(String... args) {

		//b.execute(CopyOnWriteArraySet);
		
		addMB.executeAll();
		
		//System.out.println(1000_000/100);
	}

}
