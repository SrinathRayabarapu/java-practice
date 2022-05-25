package com.puzzles.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubStringTest {

    @Test
    void findLongestPalindromicSubString() {

        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();

        assertEquals("geeksskeeg",
                longestPalindromicSubString.findLongestPalindromicSubString("forgeeksskeegfor"));

        assertEquals("ee",
                longestPalindromicSubString.findLongestPalindromicSubString("Geeks"));

    }
}