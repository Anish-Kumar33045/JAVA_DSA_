

public class Reverse {
   
    private ListNode head; 

     public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // overloaded display
    public void display(ListNode start) {
        ListNode current = start; // Start from the specified node
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
 
     // Reverse the linked list
     /*
        Purpose: Reverses the linked list and returns the new head.
        How It Works:
        1) If the list is empty (head == null), return head (no change).
        2) Initialize three pointers:
        3) current to traverse the list.
        4) previous to store the previous node.
        5) next to temporarily store the next node.
        6) Traverse the list using a while loop:
        7) Store the next node (next = current.next).
        8) Reverse the link by setting current.next to previous.
        9) Move previous to current, and current to next.
        10) Once the loop finishes, previous will be the new head of the reversed list, which is returned.
        */
    public ListNode reverse(ListNode head) {
        ListNode previous = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        
    }
}
