package djava.collections.performance;

import djava.collections.performance.CollectionBenchmark;
import djava.collections.performance.CollectionType.*;
import djava.collections.performance.MapBenchmark;
import djava.collections.performance.benchmarks.AddCollectionBenchmark;
import djava.collections.performance.benchmarks.ContainsCollectionBenchmark;
import djava.collections.performance.benchmarks.IterateCollectionBenchmark;
import djava.collections.performance.benchmarks.RemoveCollectionBenchmark;
import djava.collections.performance.benchmarks.map.AddMapBenchmark;
import djava.collections.performance.benchmarks.map.GetMapBenchmark;
import djava.collections.performance.benchmarks.map.IterateMapBenchmark;
import djava.collections.performance.benchmarks.map.RemoveMapBenchmark;

public class CollectionMapPerformance {
	
	private static CollectionBenchmark addCB = new AddCollectionBenchmark();
	private static CollectionBenchmark iterateCB = new IterateCollectionBenchmark();
	private static CollectionBenchmark containsCB = new ContainsCollectionBenchmark();
	private static CollectionBenchmark removeCB = new RemoveCollectionBenchmark();
	private static MapBenchmark addMB = new AddMapBenchmark();
	private static MapBenchmark iterateMB = new IterateMapBenchmark();
	private static MapBenchmark getMB = new GetMapBenchmark();
	private static MapBenchmark removeMB = new RemoveMapBenchmark();

	public static void main(String... args) {

		
//		addCB.executeAll();
//		iterateCB.executeAll();
//		containsCB.executeAll();
//		removeCB.executeAll();

		
//		addMB.executeAll();		
//		iterateMB.executeAll();
		getMB.executeAll();
//		removeMB.executeAll();
		

	}

}
