package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * program to left rotateRight an array on given number of times.
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ArrayRotationsMain {

    public static void main(String[] args) {

        int[] temp = {1, 2, 3, 4, 5};

		log.info("Given array : {}", Arrays.toString(temp));

        rotateLeft(temp, 3);
		log.info("Rotated left array : {}", Arrays.toString(temp));

        rotateRight(temp, 3);
		log.info("Rotated right array : {}", Arrays.toString(temp));
    }

    private static void rotateRight(int[] input, int rotations) {
        while (rotations-- > 0) {
            int temp = input[input.length - 1];
            for (int i = input.length - 2; i >= 0; i--) {
				input[i+1] = input[i];
            }
			input[0] = temp;

			log.info(Arrays.toString(input));
        }
    }

    private static void rotateLeft(int[] temp, int rotations) {
        while (rotations-- > 0) {
            int tp = temp[0];
            for (int j = 0; j < temp.length - 1; j++) {
                temp[j] = temp[j + 1];
            }
            temp[temp.length - 1] = tp;

			log.info(Arrays.toString(temp));
        }
    }

}