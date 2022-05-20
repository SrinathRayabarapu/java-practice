package com.puzzles;

import com.puzzles.palindrome.StringPalindromeMain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class StringPalindromeMainTest {

    @Test
    void isPalindrome() {
        assertFalse(StringPalindromeMain.isStringPalindrome("race a car"));
    }
}