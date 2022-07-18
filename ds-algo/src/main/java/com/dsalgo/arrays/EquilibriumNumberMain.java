package com.dsalgo.arrays;

import java.util.Arrays;

/**
 * An array of n integers is given in which we should select an equilibrium number. The equilibrium number
 * is the number for which the sum of numbers left to the equilibrium number in the array is equal to the
 * sum of elements to the right. If equilibrium number does not exist print -1
 * <p>
 * https://leetcode.com/problems/find-pivot-index/
 */
public class EquilibriumNumberMain {

    public static void main(String[] args) {

        int[] inputArray = {1, 7, 3, 6, 5, 6};

        int n = findEquilibriumNumber(inputArray);
        System.out.println(n);

    }

    /**
     * TC: O(n)
     * SC: O(1)
     * <p>
     * idea: Keep a total sum. Start comparing all i'th leftSum to total sum - left sum - i'th position. if equals then
     * i'th position is equilibrium
     * <p>
     * Works for both +ve and -ve numbers
     *
     * @param inputArray
     * @return
     */
    private static int findEquilibriumNumber(int[] inputArray) {

        int sum = Arrays.stream(inputArray).sum();

        int leftSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (leftSum == sum - leftSum - inputArray[i]) {
                return inputArray[i];
            }
            leftSum += inputArray[i];
        }

        return -1;
    }

}