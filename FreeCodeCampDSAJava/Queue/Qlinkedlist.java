import java.util.Scanner;

public class Qlinkedlist {
    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    //Qinsert 
     public void enqueue(int data){
       ListNode temp = new ListNode(data);
       System.out.println("inserted " + data + " successfully");

       if(isEmpty()){
        front = temp ;
       }
       else{
        rear.next = temp;
       }
       rear = temp;
       length++;
     }

     public void dequeue(){
        if(isEmpty()) {
            System.out.println(" Queue is Empty ");
            return ;
        }
        System.out.println("deleted " + front.data + " successfully");
        if(front == rear){
            front = null;
            rear = null;
        }
        else{
            front=front.next;
        }
        length--;
     }

     public void display(){
        if(isEmpty()) {
            System.out.println(" Queue is Empty ");
            return ;
        }

        ListNode temp = front ;
        while(temp != null){
          System.out.print(temp.data + " => ");
          temp = temp.next;
        }
       

     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option , item;

        Qlinkedlist q = new Qlinkedlist();

        while(true){
          System.out.println("\n Q operations");
          System.out.println("1. Enqueue \n2. Dequeue \n3. Display \n4. Exit \n Enter your choice : ");
          option = scanner.nextInt();

          switch (option) {
              case 1 : System.out.println("enter the data to insert : ");
                       item = scanner.nextInt();
                       q.enqueue(item);
                  
                          break;

             case 2 : 
                       q.dequeue();
                          break;
             case 3 : q.display();
                          break;
             case 4 : System.exit(0);
                      System.out.println("Exiting ...");
              default:
                 System.out.println("Invalid choice");
          }
        }
    }
}
