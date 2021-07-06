
public class Main {

	public static void main(String [] args) {
//		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
//		
//		list.addFirst(1);
//		list.addLast(2);
//		list.addLast(3);
//		list.addFirst(0);
//		
//		list.printFromHead();
//		
//		list.addNth(2, 4);
//		list.addNth(-1, 5);
//		list.addNth(10, 6);
//		
//		list.printFromHead();
		
//		DevStack<Integer> stack = new DevStack<Integer>();
//		
//		System.out.println(stack.isEmpty());
//		
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		stack.push(4);
//		
//		stack.printStack();
//		
//		System.out.println(stack.peek().toString());
//		
//		stack.printStack();
//		
//		System.out.println(stack.pop().toString());
//		
//		stack.printStack();
//		
//		stack.push(5);
//		stack.push(6);
//		
//		stack.printStack();
//		
//		System.out.println(stack.isEmpty());
//		
//		stack.flush();
//		System.out.println(stack.isEmpty());
//		stack.printStack();
		
//		DevQueue<Integer> queue = new DevQueue<Integer>(4);
//
//		queue.peek();
//
//		queue.enqueue(1);
//		queue.enqueue(2);
//		queue.enqueue(3);
//		queue.enqueue(4);
//		queue.enqueue(5);
//
//		queue.printQueue();
//
//		System.out.println(queue.peek());
//
//		queue.dequeue();
//		System.out.println(queue.peek());
//
//
//		queue.printQueue();
//		queue.enqueue(5);
//		queue.enqueue(6);
//		queue.enqueue(7);
//		queue.enqueue(8);
//
//		queue.printQueue();

		ArrStack<Integer> stack = new ArrStack<>();

		System.out.println(stack.isEmpty());

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		stack.printStack();

		System.out.println(stack.peek());

		stack.printStack();

		System.out.println(stack.pop());

		stack.printStack();

		stack.push(5);
		stack.push(6);

		stack.printStack();

		System.out.println(stack.isEmpty());


		DLLQueue<Integer> queue = new DLLQueue<>();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		queue.printQueue();

		System.out.println(queue.peek().toString());

		queue.dequeue();
		System.out.println(queue.peek().toString());


		queue.printQueue();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);

		queue.printQueue();

		
	}
}
