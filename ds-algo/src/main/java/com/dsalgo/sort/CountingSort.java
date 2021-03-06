package com.dsalgo.sort;

/**
 * Counting sort is an algorithm for sorting a collection of objects according
 * to keys that are small integers; that is, it is an integer sorting algorithm.
 * It operates by counting the number of objects that have each distinct key
 * value, and using arithmetic on those counts to determine the positions of
 * each key value in the output sequence. Family: Counting. Space: An Array of
 * length r. Stable: True.
 * 
 * Average case = O(n+r) Worst case = O(n+r) Best case = O(n+r) NOTE: r is the
 * range of numbers (0 to r) to be sorted.
 * 
 * http://en.wikipedia.org/wiki/Counting_sort
 * 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class CountingSort {

    private CountingSort() {
    }

    public static Integer[] sort(Integer[] unsorted) {
        int maxValue = findMax(unsorted);
        int[] counts = new int[maxValue + 1];
        updateCounts(unsorted, counts);
        populateCounts(unsorted, counts);
        return unsorted;
    }

    private static int findMax(Integer[] unsorted) {
        int max = Integer.MIN_VALUE;
        for (int i : unsorted) {
            if (i > max)
                max = i;
        }
        return max;
    }

    private static void updateCounts(Integer[] unsorted, int[] counts) {
        for (int e : unsorted)
            counts[e]++;
    }

    private static void populateCounts(Integer[] unsorted, int[] counts) {
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int e = counts[i];
            while (e > 0) {
                unsorted[index++] = i;
                e--;
            }
        }
    }
}
