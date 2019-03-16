package djava.collections.performance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class CollectionFactory {

	public static Collection<Integer> get(CollectionType collectionType, int collectionSize) {
		Collection<Integer> collection = get(collectionType);
		for (int i = 0; i < collectionSize; ++i) {
			collection.add(i);
		}
		return collection;
	}

	public static boolean skip(CollectionType collectionType) {
		switch (collectionType) {
		case CopyOnWriteArrayList:
			return true;
		case CopyOnWriteArraySet:
			return true;
		case EnumSet:
			return true;
		default:
			break;
		}
		return false;
	}

	public static Collection<Integer> get(CollectionType collectionType) {
		switch (collectionType) {

		// Lists
		case ArrayList:
			return new ArrayList<Integer>();
		case CopyOnWriteArrayList:
			return new CopyOnWriteArrayList<Integer>();
		case Vector:
			return new Vector<Integer>();
		case LinkedList:
			return new LinkedList<Integer>();

		// Sets
		case HashSet:
			return new HashSet<Integer>();
		case CopyOnWriteArraySet:
			return new CopyOnWriteArraySet<Integer>();
		case LinkedHashSet:
			return new LinkedHashSet<Integer>();
		case TreeSet:
			return new TreeSet<Integer>();
		case ConcurrentSkipListSet:
			return new ConcurrentSkipListSet<Integer>();
//		case EnumSet:
//			return new EnumSet<Integer>();

		// Queue
		case PriorityQueue:
			return new PriorityQueue<Integer>();
		case PriorityBlockingQueue:
			return new PriorityBlockingQueue<Integer>();

		case ArrayDeque:
			return new ArrayDeque<Integer>();
		case ArrayBlockingQueue:
			return new ArrayBlockingQueue<Integer>(1000_000);
		case LinkedBlockingQueue:
			return new LinkedBlockingQueue<Integer>(1000_000);
		default:
			break;
		}

		return null;
	}

}
