public class ListNodeOperations extends Reverse {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }
    // Method to insert at the beginning of the list
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head; // Link the new node to the current head
        head = newNode;      // Update head to point to the new node
    }

    // Count the number of nodes in the list
    public int countNodes() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Get the nth node from the end of the linked list
    public ListNode getNthNode(int n) {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty.");
        }

        ListNode mainPtr = head, refPtr = head;

        // Move refPtr n steps ahead
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException("n is larger than the list size.");
            }
            refPtr = refPtr.next;
            count++;
        }

        // Move both pointers until refPtr reaches the end
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        return mainPtr;
    }

    // remove duplicates from sorted array
    /*
     Purpose: Removes duplicate nodes from a sorted linked list.
     How It Works:
     1) If the list is empty (head == null), return immediately.
     2) Initialize a current pointer starting from head.
     3) Traverse the list using a while loop, checking if the current node's data is equal to the next node's data.
     4) If they are equal, update current.next to skip the duplicate node (current.next = current.next.next).
     5) If not, move current to the next node.
     6) The loop continues until no more duplicates are found or the end of the list is reached.
     */
    public void removeDuplicates() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Merge two sorted Linked list 
    // 1 --> 5 --> 8 --> 12 --> null 
    // 2 --> 7 --> null 
    // result 1 --> 2 --> 5 --> 7 --> 8 --> 12 --> null
    public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }

    // add two nodes
    public ListNode add(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }


    // Main method to test the implementation
    public static void main(String[] args) {
        ListNodeOperations obj = new ListNodeOperations();

        // Insert nodes into the list
        obj.insertFirst(50);
        obj.insertFirst(45);
        obj.insertFirst(35);
        obj.insertFirst(25);
        obj.insertFirst(15);
        obj.insertFirst(15);
        obj.insertFirst(5);

        ListNodeOperations obj1 = new ListNodeOperations();
        obj1.insertFirst(55);
        obj1.insertFirst(44);
        obj1.insertFirst(33);
        obj1.insertFirst(22);
        obj1.insertFirst(11);

        // Display the list
        System.out.println("Initial LinkedList is: ");
        obj.display();

        // Count and display the number of nodes
        System.out.println("Number of nodes: " + obj.countNodes());

        // Get and display the 3rd node from the end
        ListNode nthNode = obj.getNthNode(3);
        System.out.println("The 3rd node from the end is: " + nthNode);

        System.out.println("removes duplicate method ");
        obj.removeDuplicates();
        obj.display();

        // Merge the two lists
        System.out.println("After merging the two lists:");
        ListNode mergedHead = merge(obj.head, obj1.head);

        // Display the merged list
        ListNodeOperations mergedList = new ListNodeOperations();
        mergedList.head = mergedHead;
        mergedList.display();
        
        System.out.println("Adding numbers:");
        //342, which is stored as 2 -> 4 -> 3
        ListNode num1 = new ListNode(2);
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(3);

         //465, which is stored as 5 -> 6 -> 4
        ListNode num2 = new ListNode(5);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(4);

        obj.display(num1);
        obj.display(num2);

        ListNode sum = obj.add(num1, num2);  //807 would be represented as 7 -> 0 -> 8
        System.out.println("Sum:");
        obj.display(sum);

        System.out.println("Actual sum of num1 and num2 is reverse ");
        ListNode reversedSum = obj.reverse(sum);  // Save the reversed result
        obj.display(reversedSum);  // Display the reversed sum



    }
}
