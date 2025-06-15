import java.util.Scanner;

class Node {
	int data;
	Node next;
	Node(int data) {
		this.data=data;
	}
}

class list {
	Node head, tail;
	public void insert(int data) {
		Node n = new Node(data);
		if(head == null)
		{
			head = n;
			tail = n;
		}
		else {
			tail.next= n;
			tail=n;
		}

	}

	public void insertatbegin(int data) {
		Node n = new Node(data);
		n.next=head;
		head=n;
	}

	public void insertatspec(int pos, int data) {
		Node temp=head;
		Node n = new Node(data);
		for(int i=1; i<pos-1; i++) {
			temp=temp.next;
		}
		n.next=temp.next;
		temp.next=n;
	}

	public void delatbegin() {
		head=head.next;
	}

	public void delatend() {
		Node temp=head;
		while(temp.next!=tail) {
			temp=temp.next;
		}
		temp.next=null;
	}

	public void delatspec(int pos) {
		Node temp = head;
		for(int i=1; i<pos-1; i++) {
			temp=temp.next;//to traverse
		}
		temp.next= temp.next.next;
	}

	public void display() {
		Node  temp = head;
		if(head == null) {
			System.out.println("List is Empty");
		}
		else {
			while(temp!=null) {
				System.out.println(temp.data);
				temp=temp.next;// to traverse
			}
		}

	}

}

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int num4 = sc.nextInt();
		int num5 = sc.nextInt();
		int num6 = sc.nextInt();
		list l=new list();
		l.insert(num1);
		l.insert(num2);
		l.insert(num3);
		System.out.println("The updated list is:");
		l.display();
		System.out.println("After Inserting the Value at the Begining");
		l.insertatbegin(num4);
		l.display();
		System.out.println("After Inserting the Value at the Specific");
		l.insertatspec(num5, num6);
		l.display();
		System.out.println("After Deleting the Value at the Begining:");
		l.delatbegin();
		l.display();
		System.out.println("After Deleting the Value at the End:");
		l.delatend();
		l.display();
	}
}