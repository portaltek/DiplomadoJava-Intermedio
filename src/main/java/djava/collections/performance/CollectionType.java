package djava.collections.performance;

public enum CollectionType {
	ArrayList("ArrayList"), Vector("Vector"), LinkedList("LinkedList"), HashSet("HashSet"),
	LinkedHashSet("LinkedHashSet"), TreeSet("TreeSet"), PriorityQueue("PriorityQueue"), ArrayDeque("ArrayDeque"),
	ArrayBlockingQueue("ArrayBlockingQueue"), LinkedBlockingQueue("LinkedBlockingQueue"),
	CopyOnWriteArrayList("CopyOnWriteArrayList"), EnumSet("EnumSet"), ConcurrentSkipListSet("ConcurrentSkipListSet"),

	PriorityBlockingQueue("PriorityBlockingQueue"), CopyOnWriteArraySet("CopyOnWriteArraySet");
	private String value;

	public String getValue() {
		return this.value;
	}

	CollectionType(String value) {
		this.value = value;
	}
}
