package com.puzzles;

import lombok.extern.slf4j.Slf4j;

/**
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 */
@Slf4j
public class StringPalindromeMain {

    public static void main(String[] args) {
//        String input = "A man, a plan, a canal: Panama";
        String input = "0P";

        boolean ispalindrome = isStringPalindrome(input);

        if(ispalindrome)
            log.info("'{}' is a palindrome", input);
        else
            log.info("{} is NOT a palindrome", input);
    }

    private static boolean isStringPalindrome(String input) {

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

}