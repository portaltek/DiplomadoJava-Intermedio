package djava.collections;

import djava.collections.performance.Collections.*;
import djava.collections.performance.benchmarks.AddCollectionBenchmark;
import djava.collections.performance.benchmarks.CollectionBenchmark;
import djava.collections.performance.benchmarks.ContainsCollectionBenchmark;
import djava.collections.performance.benchmarks.IterateCollectionBenchmark;

public class MainClass {
	private static CollectionBenchmark iterateBenchmark = new IterateCollectionBenchmark();
	private static CollectionBenchmark addBenchmark = new AddCollectionBenchmark();
	private static CollectionBenchmark containsBenchmark = new ContainsCollectionBenchmark();

	public static void main(String... args) {

		//b.execute(CopyOnWriteArraySet);

		containsBenchmark.executeAll();
	}

}
