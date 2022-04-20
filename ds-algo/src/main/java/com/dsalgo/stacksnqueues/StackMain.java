package com.dsalgo.stacksnqueues;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class StackMain {

    public static void main(String[] args) {
        Stack<String> stack = new Stack();

        stack.push("hey");
        stack.push("Srinath");

        while(!stack.isEmpty()) {
            log.info(stack.pop());
        }
    }

}
