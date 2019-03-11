package djava.collections.performance;

public interface CollectionBenchmark {

	Long operation(Collections collectionType, int collectionSize);

	double executeOperations(Collections collectionType, int collectionSize, int times);

	void execute(Collections collectionType);

	void executeAll();

}