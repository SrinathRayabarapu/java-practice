package com.dsalgo.arrays;

/**
 * An array of n integers is given in which we should select an equilibrium number. The equilibrium number
 * is the number for which the sum of numbers left to the equilibrium number in the array is equal to the
 * sum of elements to the right. If equilibrium number does not exist print -1
 */
public class EquilibriumNumberMain {

    public static void main(String[] args) {

        int[] inputArray = {7, 2, 4, 5, 1, 3};

        int n = findEquilibriumNumber(inputArray);
        System.out.println(n);

    }

    private static int findEquilibriumNumber(int[] inputArray) {

        int rightSum = 0;
        for (int i = 1; i < inputArray.length; i++) {
            rightSum += inputArray[i];
        }

        int leftSum = 0;

        for (int i=0, j=1; j < inputArray.length; i++, j++) {
            leftSum += inputArray[i];
            rightSum -= inputArray[j];

            if(leftSum == rightSum){
                return inputArray[i+1];
            }
        }

        return -1;
    }

}