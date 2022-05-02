package com.dsalgo.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * handles below cases:
 *
 * 1. given an unsorted array, find pairs which sum equals to a given number
 * 2. given a sorted array, find pairs which sum equals to a given number
 *
 * @author Srinath.Rayabarapu
 */
public class FindPairsOfGivenSumMain {

    public static void main(String[] args) {

        int[] intArray1 = {11, 2, 4, 1, 8, 4, 10, 15, 18, 9, 5};
        int sum = 20;
        System.out.printf("Finding pairs in unsorted array for sum %d:%n", sum);
        // case 1
        // O(n) - time complexity, O(n) - space complexity
        findPairsHashSet(intArray1, sum);

        // case 2
        // O(n) - time complexity, O(1) - space complexity
        int[] intArray2 = {0, 2, 4, 6, 12, 14, 16, 20, 22, 26};
        sum = 26;
        System.out.printf("Finding pairs in sorted array for sum %d:%n", sum);
        findPairsWhileLoop(intArray2, sum);

    }

    private static void findPairsWhileLoop(int[] intArray2, int sum) {
        int l = 0;
        int r = intArray2.length-1;

        while (l < r){
            if(intArray2[l] + intArray2[r] == sum){
                System.out.println("Pair : " + intArray2[l] +", " + intArray2[r]);
                l++;
                r--;
            } else if(intArray2[l] + intArray2[r] > sum){
                r--;
            } else {
                l++;
            }
        }
    }

    // using hashset is the key
    private static void findPairsHashSet(int[] intArray, int sum) {

        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < intArray.length; i++) {
            if(intSet.contains(sum - intArray[i])){
                System.out.println("Pair : " + (sum - intArray[i]) + "," + intArray[i]);
            }
            intSet.add(intArray[i]);
        }

    }

}