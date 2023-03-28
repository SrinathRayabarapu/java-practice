package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SumOfAllSubArraysMain {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int sum = findSumWorst(arr);
        log.info("Sum : {}", sum);
    }

    private static int findSumGood(int[] arr) {

        return 0;
    }

    // TC : O(n^2)
    private static int findSumWorst(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            for (int j = i; j < arr.length; j++) {
                log.info("" + arr[j]);
                tempSum += arr[j];
                maxSum += tempSum;
            }
        }
        return maxSum;
    }

}
