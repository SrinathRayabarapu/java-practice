package com.dsalgo.linkedlist;

/**
 * given a linked list,
 * 1. check whether it is cyclic or not.
 * 2. find one node of a cycle
 * 3. remove cycle in list
 *
 * @author Srinath.Rayabarapu
 */
public class CheckLinkedListCyclicMain {

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n4); // last node is pointing back to n4

        if (isLoopPresent(n1)) {
            System.out.println("List is cyclic!");
        } else {
            System.out.println("List is NOT cyclic!");
        }

        printFirstNodeOfCycle(n1);

        Node head = removeCycleAndReturnHead(n1);

        System.out.println("Cycle removed - Printing the list");

        while (head != null) {
            System.out.println(head);
            head = head.getNext();
        }

    }

    // if a cycle exists, remove the cycle
    private static Node removeCycleAndReturnHead(Node head) {
        Node slow = head;
        Node fast = head;
        Node previous = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            previous = fast.getNext();
            fast = fast.getNext().getNext();

            // loop found
            if (slow == fast) {
                slow = head;
                // if the loop is starting at the head node
                if (slow == fast) {
                    previous.setNext(null);
                } else {
                    // identify the loop fist node and set the previous next to null
                    while (slow != fast) {
                        previous = fast;
                        slow = slow.getNext();
                        fast = fast.getNext();
                    }
                    // last element in the loop so setting next tot null
                    previous.setNext(null);
                }
            }
        }
        return head;
    }

    // if a cycle exists then print first node of cycle
    private static void printFirstNodeOfCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                // imp: assign slow pointer to start node and loop till it matches with fast
                slow = head;
                while (slow != fast) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                System.out.println("Cycle starts at : " + slow);
                break;
            }
        }

        int counter = 0;
        do {
            slow = slow.getNext();
            counter++;
        } while (slow != fast);

        System.out.println("Length of the loop : " + counter);

    }

    // find whether a cycle exists
    private static boolean isLoopPresent(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}