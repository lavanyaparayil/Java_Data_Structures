import java.util.Stack;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks ");
        int n= sc.nextInt();
        int numDisks = n;
        char source = 'S', auxiliary = 'A', destination = 'D';

        Stack<Integer> s = new Stack<>();
        Stack<Integer> a = new Stack<>();
        Stack<Integer> d = new Stack<>();

        for (int i = numDisks; i >= 1; i--) {
            s.push(i);
        }

        int totalMoves = (int) Math.pow(2, numDisks) - 1;

        if (numDisks % 2 == 0) {
            char temp = destination;
            destination = auxiliary;
            auxiliary = temp;
        }

        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisk(s, d, source, destination);
            } else if (i % 3 == 2) {
                moveDisk(s, a, source, auxiliary);
            } else {
                moveDisk(a, d, auxiliary, destination);
            }
        }
    }

    private static void moveDisk(Stack<Integer> from, Stack<Integer> to, char fromRod, char toRod) {
        if (from.isEmpty()) {
            from.push(to.pop());
            System.out.println("Move disk from rod " + "\'" + toRod + "\'" + " to rod " + "\'" + fromRod + "\'" );
        } else if (to.isEmpty()) {
            to.push(from.pop());
            System.out.println("Move disk from rod " + "\'" + fromRod + "\'" + " to rod " + "\'" + toRod + "\'");
        } else if (from.peek() > to.peek()) {
            from.push(to.pop());
            System.out.println("Move disk from rod " + "\'" + toRod + "\'" + " to rod " + "\'" + fromRod + "\'");
        } else {
            to.push(from.pop());
            System.out.println("Move disk from rod " + "\'" + fromRod + "\'" + " to rod " + "\'" + toRod + "\'");
        }
    }
}
