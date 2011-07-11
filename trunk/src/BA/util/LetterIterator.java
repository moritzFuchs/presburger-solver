package BA.util;

import java.util.Iterator;

public class LetterIterator implements Iterator<Boolean[]> {

	Boolean[] letter;
	
	public LetterIterator(Integer size) {
		letter = new Boolean[size];
		for (int i=0;i<size;i++) {
			letter[i] = false;
		}
	}
	
	@Override
	public boolean hasNext() {
		for (int i=0;i<letter.length;i++) {
			if (letter[i] == false)
				return true;
		}
		return false;
	}

	@Override
	public Boolean[] next() {
		for (int i=0;i<letter.length;i++) {
			if (!letter[i]) {
				letter[i] = true;
				break;
			} else
				letter[i] = false;
		}
		return letter;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
