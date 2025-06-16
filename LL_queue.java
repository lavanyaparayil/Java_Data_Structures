// Node class
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

// Queue class using Linked List
class List {
	Node front = null, rear = null;

	public boolean isEmpty() {
		return (front == null && rear == null);
	}

	public void enqueue(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		front = front.next;
		if (front == null) {
			rear = null;
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

// Main class
public class Main {
	public static void main(String[] args) {
		List l = new List();

		l.enqueue(10);
		l.enqueue(20);
		l.enqueue(30);
		l.enqueue(40);
		l.display();

		System.out.println("");
		l.dequeue();
		l.display();

		System.out.println("");
		l.dequeue();
		l.dequeue();
		l.dequeue();
		l.display();

		System.out.println("");
		l.dequeue();
	}
}
