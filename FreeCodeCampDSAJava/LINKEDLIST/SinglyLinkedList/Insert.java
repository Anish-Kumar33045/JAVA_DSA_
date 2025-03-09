



public class Insert {

    private  ListNode head;
     // Display the list
     // to print the singly linked list
    /*
         Purpose: Traverses and prints all elements of a linked list.
     How It Works:
       1) Starts with the head of the list.
       2) Iterates through each node using a while loop.
       3) Prints the data of the current node followed by " --> ".
       4) Moves to the next node until reaching null.
       5) Prints "null" to indicate the end of the list.
     */
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public int length(){
        if(head == null){
          return 0;
        }
        int count = 0 ;
        ListNode current = head ;
        while( current != null){
             count++;
             current = current.next;
        }
        return count;
      }
  
      // Insert at the beginning
       /*
       Purpose: Inserts a new node with the given value at the beginning of the linked list.
       How It Works:
       1) Create a new node (newNode) with the specified value.
       2) Set newNode.next to point to the current head.
       3) Update head to reference newNode, making it the new first node in the list.
       */
      
      public void insertFirst(int value) {
          ListNode newNode = new ListNode(value);
          newNode.next = head; // Link newNode to the current head
          head = newNode;      // Update head to point to newNode   
      }
  
      // Insert at the end
      /*
       Purpose: Inserts a new node with the given value at the end of the linked list.
       How It Works:
      1) Create a new node (newNode) with the specified value.
      2) If the list is empty (head == null), set head to newNode and return.
      3) Traverse the list using a while loop to find the last node (current.next == null).
      4) Set current.next to newNode, linking the new node to the end of the list.
       */
      public void insertLast(int value) {
          ListNode newNode = new ListNode(value);
          if (head == null) {
              head = newNode;
              return;
          }
          ListNode current = head;
          while (current.next != null) {
              current = current.next;
          }
          current.next = newNode;
      }
  
      // Insert at a specific position 
      /*
       Purpose: Inserts a new node with the given value at the end of the linked list.
       How It Works:
     1) Create a new node (newNode) with the specified value.
     2) If the list is empty (head == null), set head to newNode and return.
     3) Traverse the list using a while loop to find the last node (current.next == null).
     4) Set current.next to newNode, linking the new node to the end of the list.
      */
      public void insert_At_Position(int value, int position){
          ListNode node = new ListNode(value);
          if(position == 1 ){
            node.next = head ;
            head = node ;
          }
          else{
             ListNode previous = head;
             int count = 1;
             while( count < position - 1){
                previous = previous.next;
                count++;
             } 
             ListNode current = previous.next;
             node.next = current;
             previous.next = node;
          }
         }

         // Search for an element
     /*
       Purpose: Searches for a node with the given key in the linked list and returns whether it exists.
         How It Works:
         1) Start from the head of the list.
         2) Traverse the list using a while loop until current becomes null.
         3) Check if current.data matches the given key.
         4) If a match is found, return true.
         5) Move to the next node (current = current.next).
         6) If the loop completes without finding the key, return false.
       */
         public boolean searchNode(int key) {
            ListNode current = head;
            while (current != null) {
                if (current.data == key) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    public static void main(String[] args) {
        Insert obj = new Insert();
        System.out.println("Insert at first operation");
        obj.insertFirst(10);
        obj.insertFirst(20);
        obj.insertFirst(30);
        obj.display();
          
        System.out.println("insert last operation");
        obj.insertLast(50);
        obj.display();

        System.out.println("Insert at position operation");
        obj.insert_At_Position(50, 4);
        obj.display();

        System.out.println("Length of LinkedList is : "+ obj.length());

        System.out.println("Search A node by value 30 is "+obj.searchNode(30));

        
        
        
    }
}
