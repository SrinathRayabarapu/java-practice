package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from
 * these indices makes the sum of even-indexed and odd-indexed array elements equal.
 */
@Slf4j
public class SpecialIndicesCountMain {

    public static void main(String[] args) {

        int[] inputArray = {2, 1, 6, 4};

        int count = countOfSpecialIndices(inputArray);

        log.info("Special Indices count is : {}", count);
    }


    /**
     * build even pre sum
     * build odd pre sum
     * for each index, find 
     *
     *
     *
     * @param inputArray
     * @return
     */
    private static int countOfSpecialIndices(int[] inputArray) {
        return 0;
    }

}
