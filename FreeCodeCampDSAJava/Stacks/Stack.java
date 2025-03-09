import java.util.Scanner;

public class Stack {
    // Instance variables
    private ListNode top;
    private int length;
    
    // Inner class for ListNode
    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
    
    // Push operation
    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }
    
    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Pop operation
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return;
        }
        top = top.next;
        length--;
    }
    
    // Display operation
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        ListNode temp = top;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    public void peek(){
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Peek element : " + top.data);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack st = new Stack();
     
        System.out.println("STACK operations");

        int choice, val;
        while (true) { 
            System.out.println("Operations:\n1. PUSH\n2. POP\n3. Display\n4. Peek\n5. Exit");
            System.out.print("Enter the choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to be pushed: ");
                    val = scanner.nextInt();
                    st.push(val);
                    break; // Added missing break

                case 2:
                    st.pop();
                    break;

                case 3:
                    st.display();
                    break;
                case 4 : st.peek();
                          break;
                          
                case 5: System.exit(0);
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
