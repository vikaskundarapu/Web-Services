package com.vikas.restws;

import java.util.Arrays;

public class Algorithm {

	public void quicksort(int[] inputArray, int start, int end) {
		System.out.println();
	}

	public static void splitArray(int[] inputArray) {

		int wall = 0;
		int length = inputArray.length;
		int pivot = inputArray[length - 1];

		for (int i = 0; i < length - 1; i++) {
			if (inputArray[i] < pivot) {
				wall++;
			} else {
				int temp = inputArray[i];
				inputArray[i] = inputArray[wall];
				inputArray[wall] = temp;
			}
		}
		int temp = inputArray[wall];
		inputArray[wall] = pivot;
		inputArray[length - 1] = temp;
	}

	public static void main(String[] args) {
		int[] inputArray = new int[] {4,2,3,5,8,7};
		splitArray(inputArray);
		System.out.println(Arrays.toString(inputArray));
	}
}
