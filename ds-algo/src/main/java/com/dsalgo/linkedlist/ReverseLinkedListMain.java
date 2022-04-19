package com.dsalgo.linkedlist;

import static com.dsalgo.linkedlist.LinkedListUtil.printLinkedList;

/**
 * given a singly linked list, reverse it.
 *
 * recursive and iteration implementations are below.
 *
 * @author Srinath.Rayabarapu
 */
public class ReverseLinkedListMain {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        System.out.println("Printing original linked list - loop way : ");
        // printing list in loop
        printLinkedList(head);

        System.out.println("Printing original linked list - recursive way : ");
        // printing list in recursive
        printListInRecursive(head);

        System.out.println("Printing in Reverse order - No change to list: ");
        //simply print in reverse order - don't change original list structure
        printListInReverseRecursive(head);

        // it will change the original list!
        reverseLinkedListIterative(head);

        System.out.println("Printing Reversed Linked list: ");
        printLinkedList(n8);

    }

    private static void printListInRecursive(Node head) {
        if(head == null)
            return;

        System.out.println(head);
        printListInRecursive(head.getNext());
    }

    // print linked list in reverse - no change to original structure
    private static void printListInReverseRecursive(Node head) {
        if(head == null){
            return;
        }
        printListInReverseRecursive(head.getNext());
        System.out.println(head);
    }

    private static void reverseLinkedListIterative(Node head) {
        Node current = head;
        Node previous = null; // required to make this as last node

        while(current != null){
            Node next = current.getNext(); // required to go to next element/continue loop
            current.setNext(previous);
            previous = current;
            current = next;
        }
    }

}