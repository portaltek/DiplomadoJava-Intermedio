package djava.collections.util;

public enum MapType {
	HashMap("HashMap"), LinkedHashMap("LinkedHashMap"), TreeMap("TreeMap"), IdentityHashMap("IdentityHashMap"),
	WeakHashMap("WeakHashMap"), Hashtable("Hashtable"), ConcurrentHashMap("ConcurrentHashMap"), ConcurrentSkipListMap("ConcurrentSkipListMap");
	private String value;

	public String getValue() {
		return this.value;
	}

	MapType(String value) {
		this.value = value;
	}
}
