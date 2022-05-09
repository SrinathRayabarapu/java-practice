package com.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringPalindromeMainTest {

    @Test
    void isPalindrome() {
        assertTrue(StringPalindromeMain.isPalindrome("A man, a plan, a canal: Panama"));

        assertFalse(StringPalindromeMain.isStringPalindrome("race a car"));
    }
}