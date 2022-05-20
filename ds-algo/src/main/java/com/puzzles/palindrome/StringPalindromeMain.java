package com.puzzles.palindrome;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

/**
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 */
@Slf4j
public class StringPalindromeMain {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.######");

    public static void main(String[] args) {
//        String input = "A man, a plan, a canal: Panama";
        String input = "0P";

        boolean ispalindrome = isStringPalindrome(input);

        if(ispalindrome)
            log.info("'{}' is a palindrome", input);
        else
            log.info("{} is NOT a palindrome", input);

        // PALINDROME

        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Is Palindrome with additional storage?");
        long before = System.nanoTime();
        boolean result = isPalindromeWithAdditionalStorage(string);
        long after = System.nanoTime();
        System.out.println("string=" + string + " isPalindrome=" + result);
        System.out.println("Computed in " + FORMAT.format(after - before) + " ns");
        System.gc();
        System.out.println("Is Palindrome in-place?");
        before = System.nanoTime();
        result = isPalindromeInPlace(string);
        after = System.nanoTime();
        System.out.println("string=" + string + " isPalindrome=" + result);
        System.out.println("Computed in " + FORMAT.format(after - before) + " ns");
        System.gc();

        string = "ABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBA";
        System.out.println("Is Palindrome with additional storage?");
        before = System.nanoTime();
        result = isPalindromeWithAdditionalStorage(string);
        after = System.nanoTime();
        System.out.println("string=" + string + " isPalindrome=" + result);
        System.out.println("Computed in " + FORMAT.format(after - before) + " ns");
        System.gc();
        System.out.println("Is Palindrome in-place?");
        before = System.nanoTime();
        result = isPalindromeInPlace(string);
        after = System.nanoTime();
        System.out.println("string=" + string + " isPalindrome=" + result);
        System.out.println("Computed in " + FORMAT.format(after - before) + " ns");
        System.out.println();
        System.gc();

    }

    public static boolean isStringPalindrome(String input) {

        input = input.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(int i=input.length()-1; i >= 0; i--){
            if(Character.isLetterOrDigit(input.charAt(i))){
                sb.append(input.charAt(i));
            }
        }
        String reversedString = sb.toString();
        log.info("{} is reversed string", reversedString);

        sb = new StringBuilder();
        for(int i=0; i < input.length(); i++){
            if(Character.isLetterOrDigit(input.charAt(i))){
                sb.append(input.charAt(i));
            }
        }
        String originalString = sb.toString();
        log.info("{} is original string", originalString);

        return reversedString.equals(originalString);
    }


    public static final boolean isPalindromeWithAdditionalStorage(String string) {
        String reversed = new StringBuilder(string).reverse().toString();
        return string.equals(reversed);
    }

    public static final boolean isPalindromeInPlace(String string) {
        char[] array = string.toCharArray();
        int length = array.length - 1;
        int half = Math.round(array.length / 2);
        char a, b;
        for (int i = length; i >= half; i--) {
            a = array[length - i];
            b = array[i];
            if (a != b)
                return false;
        }
        return true;
    }

}