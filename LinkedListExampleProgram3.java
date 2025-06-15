import java.util.Scanner;

class Software {
	int data2;
	String data1;
	Software next;
	Software(String data1, int data2) {
		this.data1=data1;
		this.data2=data2;
	}
}

class List {
	Software head, tail;
	public void createsoftware(String data1, int data2) {
		Software n = new Software(data1, data2);
		if(head==null) {
			head = tail = n;
		}
		else {
			tail.next=n;
			tail=n;
		}
	}

	public void display() {
		Software temp=head;

		if(head==null) {
			System.out.println("Software list is empty");
		}
		else {
			while(temp!=null) {
				System.out.println(temp.data1 + " " + temp.data2);
				temp=temp.next;
			}

		}
	}

	public void minmem() {
		int min=head.data2;
		String min1=head.data1;
		Software temp=head.next;
		while(temp!=null) {
			if(temp.data2<min) {
				min=temp.data2;
				min1=temp.data1;
			}
			temp=temp.next;
		}
		System.out.println(min1 + " " + min);
	}

}

public class Main
{
	public static void main(String[] args) {
		List l = new List();
		Scanner sc = new Scanner(System.in);
		int x;
		do {

			System.out.print("1.Insert new software\n2.Display all the softwares\n3.Get the minimum memory software\n4.Exit\nEnter your choice: ");
			x = sc.nextInt();

			switch(x) {
			case 1:
				System.out.println("Enter the software name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter the memory used: ");
				int mem = sc.nextInt();
				l.createsoftware(name, mem);
				break;

			case 2:
				l.display();
				break;

			case 3:
				System.out.println("Minimum memory Software is: ");
				l.minmem();
				break;

			case 4:
				System.out.println("Exit");
				break;
			}
		}
		while(x>=1 && x<=3);
	}
}