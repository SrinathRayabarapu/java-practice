package com.puzzles;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * Program to check whether a string is Palindrome or not
 * <p>
 * 16461, abcba are Palindromes(string == reverse(string))
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class PalindromeMain {

    public static void main(String[] args) {
        String str = "abcba";
        checkPalindromeStringOk(str);

        checkPalindromeStringGood(str);

        int input = 1661;
        checkPalindromeInt(input);
    }

    /**
     * arithmetic way
     *
     * @param n
     */
    private static void checkPalindromeInt(int n) {
        //n%10 - will give last number
        //n/10 - will give whole number without last number
        int result = 0;
        int temp = n;

        while (n > 0) {
            int b = n % 10;
            n = n / 10;
            result = (result * 10) + b;
        }
        if (result == temp) {
            log.info(temp + " is palindrome");
        } else {
            log.info(temp + " is not palindrome");
        }
    }

    private static void checkPalindromeStringOk(String str) {
        StringBuilder temp = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            temp.append(str.charAt(i));
        }
        if(str.equals(temp.toString())){
            log.info( str+ " is palindrome");
        } else {
            log.info( str+ " is NOT palindrome");
        }
    }

    private static void checkPalindromeStringGood(String str) {
        boolean allMatch = IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == (str.charAt(str.length() - 1 - i)));
        if(allMatch){
            log.info( str+ " is palindrome");
        } else {
            log.info( str+ " is NOT palindrome");
        }
    }

}