import java.util.*;

// Stack class using an array
class stack {
    int top = -1;       // Tracks the index of the top element in the stack; -1 means stack is empty
    int[] arr;          // Array to store stack elements

    // Constructor to initialize the stack with given size
    public stack(int n) {
        arr = new int[n];   // Create an array of size n
    }

    // Method to push an element onto the stack
    public void push(int data) {
        if (top == arr.length - 1)      // Check if stack is full
            System.out.println("Stack is full");
        else {
            top++;                      // Increment top index
            arr[top] = data;            // Insert data at top position
        }
    }

    // Method to pop the top element from the stack
    public void pop() {
        if (top == -1)                  // Check if stack is empty
            System.out.println("Stack is Empty");
        else {
            int temp = arr[top];        // Store top element temporarily (optional)
            top--;                     // Decrement top to remove element from stack
            temp = 0;                   // Clear temp (not necessary, just a placeholder)
        }
    }

    // Method to peek (view) the top element without removing it
    public void peek() {
        if (top == -1)
            System.out.println("Stack is Empty");
        else {
            System.out.print("The popped element is" + arr[top]);  // Display top element
        }
    }

    // Method to display all elements currently in the stack
    public void display() {
        if (top == -1)
            System.out.println("Stack is Empty");
        else {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");   // Print each element from bottom to top
            }
        }
    }

    // Method to return the current number of elements in the stack
    public int size() {
        return top + 1;     // top starts at -1, so add 1 to get count
    }

    // Method to resize the array (double its capacity)
    public void resize() {
        int[] temp = new int[2 * arr.length];   // Create a new array twice the size
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];    // Copy existing elements to new array
        }
        arr = temp;             // Point arr to new bigger array
    }

    // Method to calculate the sum of all elements in the stack array
    public int add() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {  // WARNING: sums all array slots, including unused ones!
            sum = sum + arr[i];
        }
        return sum;
    }
}

// Main class to interact with user and perform stack operations
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int n = sc.nextInt();       // Get initial stack size from user

        stack s = new stack(n);     // Create stack object with size n

        int x;
        do {
            // Display menu options
            System.out.print("Choice 1. To Push\nChoice 2. To Pop\nChoice 3. To Display\nChoice 4. To Count\nAny other choice: Exit\nEnter your choice: ");
            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter the element to be pushed: ");
                    int num1 = sc.nextInt();    // Read element to push
                    s.push(num1);               // Push element on stack
                    break;

                case 2:
                    s.peek();    // Show top element before popping
                    s.pop();     // Pop element from stack
                    System.out.println("");
                    break;

                case 3:
                    System.out.print("The contents of the stack are ");
                    s.display();  // Display stack contents
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("The Number of elements in the stack are " + s.size());  // Show count
                    break;

                case 5:
                    System.out.print("Exiting");  // Exit message
                    break;
            }
        } while (x >= 1 && x < 5);   // Continue until user exits

        sc.close();  // Close scanner resource
    }
}
