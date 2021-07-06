public class ArrStack<T> {

    private CircularArray<T> arr;

    public ArrStack(int capacity) {
        this.arr = new CircularArray<T>(capacity);
    }

    public ArrStack(){
        this.arr = new CircularArray<T>();
    }

    public void push(T value) {
        this.arr.add(value);
    }

    public T peek() {
        return this.arr.getWriteValue();
    }

    public T pop() {
        return this.arr.removeWrite();
    }

    public boolean isEmpty() {
        return this.arr.isEmpty();
    }

    public void printStack() {
        if (this.arr.isEmpty()) {
            System.out.println("Stiva este goala");
            return;
        }

        this.arr.printArray();
    }
}
