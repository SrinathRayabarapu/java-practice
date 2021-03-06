package com.dsalgo.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * removing duplicates in following ways:
 * 1. given an sorted array, remove duplicates and print the array
 * 2. given an unsorted array, remove duplicates and print them
 *
 * @author Srinath.Rayabarapu
 */
public class ArraysRemoveDuplicatesMain {

    private static final Logger LOG = LoggerFactory.getLogger(ArraysRemoveDuplicatesMain.class);

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4};

        /*
        int uniqueArrayLength = removeDuplicatesWithExtraSpace(nums);
        LOG.info("Unique elements with extra space : {}", uniqueArrayLength);

        uniqueArrayLength = removeDuplicatesWithoutExtraSpace(nums);
        LOG.info("Unique elements without extra space : {}", uniqueArrayLength);
        */

        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4};

        // returns unique elements count
        int uniqueArrayLength = bestRemoveDuplicatesWithoutExtraSpace(nums1);
        LOG.info("BEST Unique elements without extra space : {}", uniqueArrayLength);
        System.out.println(Arrays.toString(nums1));

        System.out.println("");
        int[] num2 = {2, 3, 1, 2, 3};
        findDuplicates(num2);
    }

    private static void findDuplicates(int[] arr) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] % arr.length;
            if(arr[index] / arr.length == 1){
                found = true;
                System.out.print(index+" ");
            }
            arr[index] = arr[index] + arr.length;
        }
        if(!found){
            System.out.println(-1);
        }
    }

    /**
     * Good in runtime. Copied from submitted solutions.
     *
     * @param nums
     * @return
     */
    private static int bestRemoveDuplicatesWithoutExtraSpace(int[] nums) {

        if (nums.length == 0)
            return 0;

        //slow pointer
        int i = 0;
        //fast pointer - j
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * create a temp array and store the unique elements in there.
     *
     * @param nums
     * @return
     */
    private static int removeDuplicatesWithoutExtraSpace(int[] nums) {

        int length = nums.length;

        if (length == 0 || length == 1) {
            return length;
        }

        int j = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] != nums[i + 1])
                nums[j++] = nums[i];

        nums[j++] = nums[length - 1];

        LOG.info("Unique elements array : {}", nums);
        return j;
    }

    /**
     * method don't use extra space and only compares i and i+1 element and replace back the unique value.
     *
     * @param nums the nums int array
     */
    private static int removeDuplicatesWithExtraSpace(int[] nums) {
        int length = nums.length;

        if (length == 0 || length == 1) {
            return length;
        }

        int j = 0;
        int[] temp = new int[length];

        //compare two elements, if they are not equal then increment a counter
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] != nums[i + 1])
                temp[j++] = nums[i];

        // observe above, only nums[i] value is being copied, hence copy the last element as well
        temp[j++] = nums[length - 1];

        LOG.info("Unique elements array : {}", temp);

        return j;
    }

}