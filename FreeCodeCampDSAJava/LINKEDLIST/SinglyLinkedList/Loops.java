

public class Loops {
 
     private  ListNode head;

     // Detect a loop
     //detect a loop in LinkedList
    //  head --> 1 --> 2 --> 3 --> 4    //loop
    //                       |     |    
    //                       6 <-- 5

    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) 
            return true;
        }
        return false;
    }

     //removes loop 
     public void removeLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(ListNode slowPtr){
       ListNode temp = head;
       while(temp != slowPtr){
        temp = temp.next;
        slowPtr = slowPtr.next;
       }
       slowPtr.next = null;
    }

    public void createALoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head= first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }
    public static void main(String[] args) {
        Loops obj = new Loops();
        obj.createALoopInLinkedList();

        System.out.println("loop exists ?? : "+obj.containsLoop());

        obj.removeLoop();
        System.out.println("loop exists ?? : "+obj.containsLoop());
    }
}
