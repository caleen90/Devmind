
public class DoubleLinkedList<T> {
	
	private int size;
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;
	
	public DoubleLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public void addFirst(T value) {
		if (this.isEmpty()) {
			this.head = new DoubleLinkedListNode(value);
			this.tail = this.head;
			this.size++;
		} else {
			DoubleLinkedListNode tmp = new DoubleLinkedListNode(value);
			tmp.next(this.head);
			this.head.previous(tmp);
			this.head = tmp;
			this.size++;
		}
	}
	
	public void addLast(T value) {
		if (this.isEmpty()) {
			this.tail = new DoubleLinkedListNode(value);
			this.head = this.tail;
			this.size++;
		} else {
			DoubleLinkedListNode tmp = new DoubleLinkedListNode(value);
			tmp.previous(this.tail);
			this.tail.next(tmp);
			this.tail = tmp;
			this.size++;
		}
	}
	
	public void addNth(int index, T value) {
		if (index <= 0) {
			this.addFirst(value);
		} else if (index >= this.size) {
			this.addLast(value);
		} else {
			int it = 0;
			DoubleLinkedListNode listIt = this.head;
			
			while (it < index - 1) {
				listIt = listIt.next();
				it++;
			}
			
			DoubleLinkedListNode tmp = new DoubleLinkedListNode(value);
			
			tmp.previous(listIt);
			tmp.next(listIt.next());
			
			listIt.next(tmp);
			tmp.next().previous(tmp);
			this.size++;
		}
	}

	public T removeFirst() {
		T result = null;
		
		if (this.isEmpty()) {
			return null;
		} else if (this.size == 1) {
			result = this.head.value();
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			result = this.head.value();
			DoubleLinkedListNode tmp = this.head.next();
			this.head.next(null);
			tmp.previous(null);
			this.head = tmp;
			this.size--;
		}
		
		return result;
	}
	
	public T removeLast() {
		T result = null;
		
		if (this.isEmpty()) {
			return null;
		} else if (this.size == 1) {
			result = this.tail.value();
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			result = this.tail.value();
			DoubleLinkedListNode tmp = this.tail.previous();
			this.tail.previous(null);
			tmp.next(null);
			this.tail = tmp;
			this.size--;
		}
		
		return result;
	}
	
	public T removeNth(int index) {
		T result = null;
		
		if (index <= 0) {
			return this.removeFirst();
		} else if (index >= this.size) {
			return this.removeLast();
		} else {
			int it = 0;
			DoubleLinkedListNode listIt = this.head;
			
			while (it < index) {
				listIt = listIt.next();
				it++;
			}
			
			result = listIt.value();
			
			listIt.previous().next(listIt.next());
			listIt.next().previous(listIt.previous());
			
			listIt.next(null);
			listIt.next(null);
			this.size--;
		}
		
		return result;
	}
	
	public T getHeadValue() {
		return this.head.value();
	}
	
	public T getTailValue() {
		return this.tail.value();
	}
	
	public boolean isEmpty() {
		return (this.size == 0);
	}

	public void flush() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
 	public void printFromHead() {
		DoubleLinkedListNode it = this.head;
		
		while (it != this.tail) {
			System.out.print(it.value().toString() + " -> ");
			it = it.next();
		}
		System.out.print(this.tail.value().toString());
		System.out.println();
	}
	
	public void printFromTail() {
			DoubleLinkedListNode it = this.tail;
			
			while (it != this.head) {
				System.out.print(it.value().toString() + " -> ");
				it = it.previous();
			}
			System.out.print(this.head.value().toString());
			System.out.println();
	}
	
	private class DoubleLinkedListNode {
		private T value;
		private DoubleLinkedListNode next;
		private DoubleLinkedListNode previous;
		
		public DoubleLinkedListNode(T value, 
									DoubleLinkedListNode next, 
									DoubleLinkedListNode previous) {
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		public DoubleLinkedListNode(T value) {
			this(value, null, null);
		}
		
		public DoubleLinkedListNode() {}
		
		public T value() {
			return this.value;
		}
		
		public void value(T value) {
			this.value = value;
		}
		
		public DoubleLinkedListNode next() {
			return this.next;
		}
		
		public void next(DoubleLinkedListNode next) {
			this.next = next;
		}
		
		public DoubleLinkedListNode previous() {
			return this.previous;
		}
		
		public void previous(DoubleLinkedListNode previous) {
			this.previous = previous;
		}
	}
}
