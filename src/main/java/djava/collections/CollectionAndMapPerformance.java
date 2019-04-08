package djava.collections;

import djava.collections.performance.CollectionBenchmark;
import djava.collections.performance.MapBenchmark;
import djava.collections.performance.collections.AddCollectionBenchmark;
import djava.collections.performance.collections.ContainsCollectionBenchmark;
import djava.collections.performance.collections.IterateCollectionBenchmark;
import djava.collections.performance.collections.RemoveCollectionBenchmark;
import djava.collections.performance.maps.AddMapBenchmark;
import djava.collections.performance.maps.GetMapBenchmark;
import djava.collections.performance.maps.IterateMapBenchmark;
import djava.collections.performance.maps.RemoveMapBenchmark;

@SuppressWarnings("unused")
public class CollectionAndMapPerformance {
	
	
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
