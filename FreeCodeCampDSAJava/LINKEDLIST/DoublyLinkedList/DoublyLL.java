/*
 *  it is called two way LInkedlist
 *  we can navigate list in both forward and backward direction
 *  in singly linked list to delete the node we need pointer to its previous node 
 *  but in doubly linked list we don't nedd any pointer to it's previous
 * 
 * List Node in Doubly Linked List : 
 *   <--- previous | data | next ---> 
 * 
 *            head                        tail
                ^                          ^
    null <---| |1| | ---> | |10| | ---> | |15| |---> null
                     <---          <---
 */

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoublyLL{

    public ListNode head;
    public ListNode tail;
    int length;

    public class ListNode {
       protected int data;
       protected ListNode previous;
       protected ListNode next;

          public ListNode (int data){
             this.data = data;
          }
    }

    public DoublyLL(){
        this.head = null;
        this.tail = null;
        this.length = 0 ;
    }

    public boolean isEmpty(){
        return length == 0 ; //head == null
    }

    public int length (){
        return length;
    }
    
    // implement the Doubly Linked List
    public void displayForward(){
        if(head == null){
            return ;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    } 

    public void displayBackward(){
        if (tail == null){
            return;
        }
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // insert the node at beginning of Doubly Lnked List
       public void insertFront(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            tail = newNode;
        }
        else{
            head.previous = newNode;
            newNode.next = head ;
        }
        head = newNode;
        length++;
       }

         // insert the node at end of Doubly Lnked List
         public void insertRear (int value) {
            ListNode newNode = new ListNode(value);
            if( isEmpty() ) { 
                head = newNode; 
            }
            else{
                tail.next = newNode;
                newNode.previous = tail;
            }
              tail = newNode;  
            length++;
           }


       // delete first node in doubly linked list
          public ListNode deleteFront() {
         if(isEmpty()){
            throw new NoSuchElementException();
         } 
          ListNode temp = head;
          if(head == tail){
            tail = null;
          }
          else {
            head.next.previous = null;
          }
          head = head.next;
          temp.next = null;
          return temp;

          }
 
           // delete last node in doubly linked list
           public ListNode deleteRear() {
            if(isEmpty()){
               throw new NoSuchElementException();
            } 
             ListNode temp = tail;
            
             if(head == tail){
               head = null;
             }
             else {
               tail.previous.next = null;
             }
             tail = tail.previous;
             temp.previous = null;
             return temp;
   
             }
   

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        DoublyLL dll = new DoublyLL();
        int choice, value;

        System.out.println("Circular linked list operations");

        while (true) {
            System.out.println("\nCCL operations:");
            System.out.println("1. InsertFront\n2. InsertRear\n3. DeleteFront\n4. DeleteRear\n5. DisplayForward \n 6.DisplayBackward \n7. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value: ");
                    value = in.nextInt();
                    dll.insertFront(value);
                    break;
                case 2:
                    System.out.print("Enter the value: ");
                    value = in.nextInt();
                    dll.insertRear(value);
                    break;
                case 3:
                    System.out.println("Element deleted: " + dll.deleteFront().data);
                    break;
                case 4:
                    System.out.println("Element deleted: " + dll.deleteRear().data);
                    break;
                case 5:
                    dll.displayForward();
                    break;
                case 6:
                    dll.displayBackward();
                    break;
                case 7:
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
         
    }
         
  