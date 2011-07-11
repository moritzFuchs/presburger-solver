package BA.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implements a Worklist which is needed for most of the algorithms used in this project.
 * 
 * @author moritzfuchs
 *
 * @param <T>
 */
public class Worklist<T> {

	private LinkedList<T> list = new LinkedList<T>(); 
	
	public void add(T item) {
		list.addLast(item);
	}
	
	public void addAll(Collection<T> items) {
		Iterator<T> it = items.iterator();
		while (it.hasNext()) {
			list.addLast(it.next());
		}
	}
	
	public boolean contains(T x) {
		return list.contains(x);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public T get() {
		return list.removeFirst();
	}
	
}
