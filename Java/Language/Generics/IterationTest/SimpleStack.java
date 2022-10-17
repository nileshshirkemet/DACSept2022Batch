import java.util.Iterator;

class SimpleStack<V> implements Iterable<V> {

	private Node top;

	class Node {

		V value;
		Node below;

		Node(V item) {
			value = item;
			below = top;
		}
	}

	public void push(V item) {
		top = new Node(item);
	}

	public V pop() {
		V item = top.value;
		top = top.below;
		return item;
	}

	public boolean empty() {
		return top == null;
	}

	public Iterator<V> iterator() {
		//returning a new instance of an inner local anonymous
		//class which implements Iterator<V>
		return new Iterator<V>() {

			Node current = top;

			public boolean hasNext() {
				return current != null;
			}	

			public V next() {
				V item = current.value;
				current = current.below;
				return item;
			}
		};
	}
}

