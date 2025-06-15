import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class List {
    Node head, tail;

    public void create(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("Employees ID list is empty");
        } else {
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public int search(int rem) {
        int pos = 1;
        Node curr = head;
        while (curr != null) {
            if (curr.data == rem) {
                return pos;
            }
            curr = curr.next;
            pos++;
        }
        return -1;
    }

    public void remove(int pos) {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }

        if (pos == 1) {
            head = head.next;
            if (head == null) { // list became empty
                tail = null;
            }
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Position out of range.");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Position out of range.");
            return;
        }

        temp.next = temp.next.next;

        if (temp.next == null) { // removed last node, update tail
            tail = temp;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List l = new List();
        Scanner s1 = new Scanner(System.in);
        int ch, data;

        do {
            System.out.print("1.Insert a new Employee\n2.Display the Employees\n3.Remove an Employee ID\n4.Exit\nEnter your choice: ");
            ch = s1.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    data = s1.nextInt();
                    l.create(data);
                    break;

                case 2:
                    System.out.println("Display:");
                    l.display();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int rem = s1.nextInt();
                    int pos = l.search(rem);
                    if (pos == -1) {
                        System.out.println("Employee ID not found.");
                    } else {
                        l.remove(pos);
                        System.out.println("After remove:");
                        l.display();
                    }
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (ch >= 1 && ch < 4);

        s1.close();
    }
}
