import java.util.*;
public class Main{  
public static void main(String[] args) {  
    int choice=0;  
    Scanner sc = new Scanner(System.in); 
    System.out.println();    
    System.out.println("Enter the maximum size of the stack");  
    int n=sc.nextInt();  
    Stack s = new Stack(n); 
    do{
        System.out.println("Choice 1 : Push\nChoice 2 : Pop\nChoice 3 : Display\nAny other choice : Exit");  
        System.out.println("Enter your choice");        
        choice = sc.nextInt();  
        switch(choice)  
        {  
            case 1:  
            {   
                System.out.println("Enter the element to be pushed");
                int a=sc.nextInt();
                sc.nextLine();
                s.push(a);
                break;  
            }  
            case 2:  
            {  
                int b = s.pop();
                if(b!=-1000)
                System.out.println("The popped element is "+b);
                break;  
            }  
            case 3:  
            {  
                System.out.print("The contents of the stack are ");
                s.display();
                break;  
            }  
            default:  
            {  
                System.exit(0);  
                break; 
            }    
    }
    }while(choice<4);
}
}  
public class Stack{

    private int top;
    private int[] arr;
    Stack(int size){
        arr = new int[size];
        top = -1;
    }

    public void push(int data)
    {
        if(top == arr.length-1){
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = data;
    }

    public int pop()
    {
        if(top == -1){
            System.out.println("Stack is empty");
            int s = -1000;
            return s;
        }
        int temp = arr[top];
        top--;
        return temp;
    }

    public void display()
    {
        if(top == -1){
            System.out.println("{}");
            return;
        }
        for(int i = 0; i <= top; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
