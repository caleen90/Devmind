
public class CircularArray<T> {

	private int capacity;
	private int size;
	private int read;
	private int write;
	private T [] elements;
	
	@SuppressWarnings("unchecked")
	public CircularArray() {
		this.capacity = 10;
		this.size = 0;
		this.read = 0;
		this.write = 0;
		this.elements = (T[])new Object[this.capacity];
	}
	
	@SuppressWarnings("unchecked")
	public CircularArray(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.read = 0;
		this.write = 0;
		this.elements = (T[])new Object[this.capacity];
	}
	
	public void add(T value) {
		if (this.size == this.capacity) {
			System.out.println("Container is full!");
		} else {
			this.elements[write] = value;
			this.size++;
			this.write = (this.write + 1) % this.capacity;
		}
	}
	
	public T getReadValue() {
		if (this.isEmpty()) {
			System.out.println("Container is empty!");
			return null;
		}
		
		return this.elements[this.read];
	}
	
	public T getWriteValue() {
		if (this.isEmpty()) {
			System.out.println("Container is empty!");
			return null;
		}
		
		return this.elements[this.write - 1];
	}
	
	public T remove() {
		if (this.isEmpty()) {
			System.out.println("Container is empty!");
			return null;
		}
		
		T result = this.elements[this.read];
		this.read = (this.read + 1) % this.capacity;
		this.size--;
		
		return result;
	}
	
	public T removeWrite() {
		if (this.isEmpty()) {
			System.out.println("Container is empty!");
			return null;
		}
		
		T result = this.elements[this.write - 1];
		this.size--;
		if (this.size != 0) {
			this.write = (this.write - 1) % this.capacity;
		}
		return result;
	}
	
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	public void printArray() {
		int it = this.read;
		int i = 0;
		
		while (i < size) {
			System.out.print(((T)this.elements[it]).toString() + "->");
			it = (it + 1) % capacity;
			i++;
		}
		System.out.println();
	}
}
