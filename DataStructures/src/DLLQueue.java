public class DLLQueue<T> {
    private DoubleLinkedList<T> list;

    public DLLQueue() {
        this.list = new DoubleLinkedList<T>();
    }

    public T peek() {
        return this.list.getHeadValue();
    }

    public void enqueue(T value) {
        this.list.addLast(value);
    }

    public T dequeue() {
        return this.list.removeFirst();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void printQueue() {
        if (this.list.isEmpty()) {
            System.out.println("Coada este goala");
            return;
        }

        this.list.printFromHead();
    }
}
