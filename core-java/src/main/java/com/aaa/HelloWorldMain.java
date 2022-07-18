package com.aaa;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class HelloWorldMain {

    public static void main(String[] args) {

        String abc = "abccbaabcdefg";

        int length = findLongestUniqueSubString(abc);
        System.out.println("length = " + length);

    }

    public Node reverseLinkedList(Node head){

        Node current = head;
        Node previous = null;

        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }


    private static int findLongestUniqueSubString(String input) {

        if(input.length() <= 1){
            return input.length();
        }

        int left=0;
        int right=0;

        int count = -1;

        Set<Character> set = new HashSet<>();

        while(right < input.length()){

            char c = input.charAt(right);

            while (set.contains(c)){
                set.remove(input.charAt(left++));
            }
            set.add(c);
            count = Math.max(count, right-left+1);
            right++;
        }

        return count;
    }

}

class Node {
    int value;
    Node next;
}
