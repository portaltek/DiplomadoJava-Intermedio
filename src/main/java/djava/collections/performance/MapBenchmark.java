package djava.collections.performance;

public interface MapBenchmark {

	public abstract void beforeOperation(MapType type, int size);

	public abstract void operation(MapType type, int size);

	double executeOperations(MapType collectionType, int collectionSize, int times);

	void execute(MapType collectionType);

	void executeAll();

}