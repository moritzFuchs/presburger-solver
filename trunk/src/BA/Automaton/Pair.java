package BA.Automaton;

public class Pair<T,V> {

	private T first;
	private V second;
	
	public void setFirst(T x) {
		first = x;
	}
	
	public void setSecond(V x) {
		second = x;
	}
	
	public T getFirst() {
		return first;
	}
	
	public V getSecond() {
		return second;
	}
	
	public boolean equals(Pair<T,V> x) {
		return (first == x.getFirst() && second == x.getSecond());
	}
	
}
