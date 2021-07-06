
public class DevQueue<T> {
	
	private CircularArray<T> arr;
	
	public DevQueue(int capacity) {
		arr = new CircularArray<T>(capacity);
	}
	
	public DevQueue() {
		arr = new CircularArray<T>();
	}
	
	public T peek() {
		return this.arr.getReadValue();
	}
	
	public void enqueue(T value) {
		this.arr.add(value);
	}
	
	public T dequeue() {
		return this.arr.remove();
	}
	
	public boolean isEmpty() {
		return this.arr.isEmpty();
	}
	
	public void printQueue() {
		if (this.arr.isEmpty()) {
			System.out.println("Coada este goala");
			return;
		}
		
		this.arr.printArray();
	}
}
