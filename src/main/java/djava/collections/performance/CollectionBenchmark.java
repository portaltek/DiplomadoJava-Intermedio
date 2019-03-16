package djava.collections.performance;

public interface CollectionBenchmark {

	public void beforeOperation(CollectionType collectionType, int collectionSize);

	public void operation(CollectionType collectionType, int collectionSize);

	public double executeOperations(CollectionType collectionType, int collectionSize, int times);

	public void execute(CollectionType collectionType);

	public void executeAll();

}