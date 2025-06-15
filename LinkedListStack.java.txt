import java.util.Scanner;

// Node class for LinkedList
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class stack {
    Node top;  // Points to the top of the stack
    int size;

    public stack() {
        top = null;
        size = 0;
    }

    // Push element on top
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop element from top
    public void pop() {
        if (top == null) {
            System.out.println("Stack is Empty");
        } else {
            int popped = top.data;
            top = top.next;
            size--;
            System.out.println("Popped element is " + popped);
        }
    }

    // Peek top element
    public void peek() {
        if (top == null)
            System.out.println("Stack is Empty");
        else
            System.out.println("The top element is " + top.data);
    }

    // Display all elements
    public void display() {
        if (top == null)
            System.out.println("Stack is Empty");
        else {
            Node current = top;
            System.out.print("The contents of the stack are: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Return number of elements
    public int size() {
        return size;
    }

    // Sum all elements in the stack
    public int add() {
        int sum = 0;
        Node current = top;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack s = new stack(); // No size needed for linked list stack

        int x;
        do {
            System.out.print("Choice 1. To Push\nChoice 2. To Pop\nChoice 3. To Display\nChoice 4. To Count\nChoice 5. To Sum\nAny other choice: Exit\nEnter your choice: ");
            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter the element to be pushed: ");
                    int num1 = sc.nextInt();
                    s.push(num1);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.display();
                    break;

                case 4:
                    System.out.println("The Number of elements in the stack are " + s.size());
                    break;
                
                case 5:
                    System.out.println("Sum of all elements in the stack is " + s.add());
                    break;

                default:
                    System.out.println("Exiting");
                    break;
            }
        } while (x >= 1 && x <= 5);

        sc.close();
    }
}
