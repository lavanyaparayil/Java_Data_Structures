import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        MyStack s = new MyStack();

        int size = scan.nextInt();
        int pid = scan.nextInt();
        char prev = ' ';

        s.initStack(size, pid);

        for(int i=0; i<size; i++){
            char ch = scan.next().charAt(0);
            if(ch == 'F'){
                pid = scan.nextInt();
                s.push(pid);
            }
            else if(ch == 'R'){
                if(prev == 'R'){
                    s.push(s.getTemp());
                }
                else{
                    s.pop();    
                }
                
            }
            else{
                System.out.println("Invalid input");
            }
            prev = ch;
        }
        s.peek();
    }
    
}

class MyStack{
    private int top;
    private int[] arr;
    int temp = 0;
    public void initStack(int size, int pid){
        arr = new int[size];
        top = -1;
        push(pid);
    }
    public void push(int pid){
            top++;
            arr[top] = pid;
    }
    public void pop(){
        if(top == -1){
            System.out.println("Stack is empty");
        }
        else{
            temp = arr[top];
            top--;
        }
    }
    public void peek(){
        if(top == -1){
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println("Player " + arr[top]);
        }
    }
    public int getTemp(){
        return temp;
    }
}