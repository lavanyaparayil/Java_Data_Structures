import java.util.*;

public class Main {
    public static boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        String s = s1.nextLine();

        if (valid(s)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
