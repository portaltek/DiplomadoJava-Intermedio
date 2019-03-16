package djava.collections.performance;

public interface MapBenchmark {

	Long operation(MapType collectionType, int collectionSize);

	double executeOperations(MapType collectionType, int collectionSize, int times);

	void execute(MapType collectionType);

	void executeAll();

}