package BA.util;

import java.util.Iterator;

public class LetterIterable implements Iterable<Boolean[]>{

	Integer size = 0;
	
	public LetterIterable(int size) {
		this.size = size;
	}
	
	public Iterator<Boolean[]> iterator() {
		return new LetterIterator(this.size);
	}
	
}
