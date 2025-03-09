




public class Delete {
 
     private  ListNode head;
      // Delete the first node
      /*
       Purpose: Removes and returns the first node of the linked list.
          How It Works:
        1) If the list is empty (head == null), return null.
        2) Store the current head in a temporary variable (temp).
        3) Update head to point to the second node (head.next).
        4) Detach the removed node by setting temp.next to null.
        5) Return the removed node (temp).
        */
    public ListNode deleteFirst() {
        if (head == null) return null;
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // Delete the last node
     /*
        Purpose: Removes and returns the last node from the linked list.
       How It Works:
        1) If the list is empty (head == null) or contains only one node (head.next == null), return head.
        2) Use two pointers:
        3) current to traverse the list.
        4) previous to track the node before current.
        5) Traverse the list using a while loop until current.next == null (last node).
        6) Set previous.next to null to detach the last node.
        7) Return current, which is the deleted last node

        */
    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            ListNode temp = head;
            head = null;
            return temp;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    // Delete a node at a specific position
     /*
        Purpose: Deletes a node at a specified position in the linked list.
          How It Works:
          1) If the position is 1, update head to point to head.next, effectively removing the first node.
          2) Otherwise, use a previous pointer to traverse the list until the node just before the target position.
          3) Use a while loop with a counter (count) to stop at position - 1.
          4) Store the node to be deleted in current (previous.next).
          5) Update previous.next to skip the current node and point to current.next.
          6) The current node is now removed from the list.
     */
    public void deleteNode_Pos(int position){
        if(position == 1){
          head = head.next;
        }
        else {
          ListNode previous = head;
          int count = 1;
          // to reach to previous node
          while(count < position - 1 ){
            previous = previous.next;
            count++;
          }
          ListNode current = previous.next;
          previous.next = current.next;
        }
       }


     // to delete a given key element from linked list
/*
 
 */
public void deleteNode(int key){
    ListNode current = head;
    ListNode temp = null;

    if(current != null && current.data == key){ // means removing first element
       head = current.next;  
       return;
    }
   
    while(current != null && current.data != key){
       temp = current;
       current = current.next;
    }
    if(current == null){ // means end of ListNode
        return;
    }
  temp.next = current.next;
}

 public void display(){
  ListNode current = head;

  while(current != null){
    System.out.print(current.data +" --> ");
    current = current.next;
  }
  System.out.println("null");

 }
    public static void main(String[] args) {
      Delete obj = new Delete();

       obj.head = new ListNode(10);      //why??
      ListNode second = new ListNode(20);
      ListNode third = new ListNode(30);
      ListNode fourth = new ListNode(40);
      ListNode fifth = new ListNode(50);
        
      obj.head.next = second;  // why ??
      second.next = third;
      third.next = fourth;
      fourth.next = fifth;
        
      System.out.println("intial Linked list");
      obj.display();

      System.out.println("delete at first node");
      obj.deleteFirst();
      obj.display();

      System.out.println("delete at last node");
      obj.deleteLast();
      obj.display();

      System.out.println("delete at positiion 1 ");
      obj.deleteNode_Pos(1);
      obj.display();

      System.out.println("delete the value 30 ");
      obj.deleteNode(30);
      obj.display();
    }
}
