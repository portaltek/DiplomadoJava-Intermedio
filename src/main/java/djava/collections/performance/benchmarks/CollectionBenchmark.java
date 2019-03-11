package djava.collections.performance.benchmarks;

import djava.collections.performance.Collections;

public interface CollectionBenchmark {

	Long operation(Collections collectionType, int collectionSize);

	double executeOperations(Collections collectionType, int collectionSize, int times);

	void execute(Collections collectionType);

	void executeAll();

}