import java.util.Scanner;
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

class list {
	Node head, tail;

	public void insert(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	public void findmax() {
		int max = head.data;
		Node temp = head.next;
		while (temp != null) {
			if(temp.data>max) {
				max=temp.data;
			}
			temp = temp.next;
		}
		System.out.println(max);
	}

	public int search(int key) {
		int pos = 1;
		Node temp = head;
		while (temp != null) {
			if (temp.data == key) {
				return pos;
			}
			temp = temp.next;
			pos++;
		}
		return -1; // Not found
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void reverse() {
		Node prev = null, nxt = null;
		Node cur = head;
		while (cur != null) {
			nxt = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nxt;
		}
		head = prev;
	}
}

public class Main {
	public static void main(String[] args) {
		list l = new list();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);

		System.out.println("Original list:");
		l.display();

		System.out.println("Max element is: ");
		l.findmax();

		System.out.print("Enter the value: ");
		Scanner sc= new Scanner(System.in);
		int k=sc.nextInt();
		int pos = l.search(k);
		if (pos != -1) {
			System.out.println("Position: " + pos);
		} else {
			System.out.println("Element not found in the list.");
		}
	}
}