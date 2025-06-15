import java.util.Scanner;

class food_court{
    int data;
    food_court next;
    food_court(int data){
        this.data=data;
    }
}

class list{
    food_court head, tail;
    public void append(int data)
    {
    food_court n = new food_court(data);
    if(head == null)
    {
    head = n;
    tail = n;
       
    }
    else
    {
        tail.next= n;
        tail=n;
    }
    }
     public void display(){
    food_court  temp = head;
    if(head == null){
        System.out.println("No Transcations");
    }
    else{
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
       
    }
   
    public void sum(){
         food_court  temp = head;
         int total =0;
    if(head == null){
        System.out.println("Your score is NIL");
    }
    else{
        while(temp!=null){
          total += temp.data;
            temp=temp.next;
        }
         System.out.println("Gained points:" +total);
    }
       
    }
}

public class Main
{
public static void main(String[] args) {
   list l = new list();
   Scanner sc = new Scanner(System.in);
   int x;
   do
   {
       System.out.println("1. Visit the food court\n2. View my transactions\n3. Show my points\nEnter your choice: ");
       
       x = sc.nextInt();
       
       switch(x){
           
           case 1:
               System.out.println("Pay bill amount: ");
               int amt = sc.nextInt();
               l.append(amt);
               break;
               
          case 2:
               l.display();
               break;
               
          case 3:
             l.sum();
              break;
             
          case 4:
              System.out.println("Please Visit Again");
              break;
       }
   }
   while(x>=1 && x<=3);
}
}