
public class DevStack<T> {

	private DoubleLinkedList<T> list;
	
	public DevStack() {
		this.list = new DoubleLinkedList<T>();
	}
	
	public void push(T value) {
		this.list.addLast(value);
	}
	
	public T peek() {
		return this.list.getTailValue();
	}
	
	public T pop() {
		return this.list.removeLast();
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
	
	public void flush() {
		this.list.flush();
	}
	
	public void printStack() {
		if (this.list.isEmpty()) {
			System.out.println("Stiva este goala");
			return;
		}
		
		this.list.printFromTail();
	}
}
