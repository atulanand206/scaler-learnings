package com.atul.scaler.lean.arrays.firstmissinginteger;

/**
 * Problem: Given an unsorted integer array A of size N. Find the first missing positive integer.
 *
 * <p>Note: Your algorithm should run in O(n) time and use constant space.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 100000
 *
 * <p>-10^9 <= A[i] <= 10^9
 *
 * <p>Input: First argument is an integer array A.
 *
 * <p>Output: Return an integer denoting the first missing positive integer.
 *
 * <p>Approach: In an array, we have to find the first positive number that is not present.
 *
 * <p>Basic Observation: We are only concerned with positive numbers, we can just delete the rest
 * from the array in a single pass giving a reduced input for computation. This is not necessary for
 * the implemented approach.
 *
 * <p>Brute Force: Starting at 1, a while loop can iterate throughout the array and check if the
 * value is present or not. If it's not present, we have the answer; otherwise, we move on to the
 * next natural number. This will take O(n^2) time complexity & O(1) space complexity.
 *
 * <p>Sorting: We can sort the array using any library in O(nlogn) time complexity. A single pass
 * through starting from 1 checking if the next positive integer is present or not. If not present,
 * we have the answer. This will take O(nlogn) time complexity & O(1) space complexity.
 *
 * <p>Neat Observation: In an array of size N, only the first N natural numbers will fit in. If all
 * of them are present, then the answer is N + 1.
 *
 * <p>Flag Array: We can mark indices as present while iterating through the array. Another
 * iteration over the Flag array to check which number is not marked starting from 1. This will take
 * O(n) time complexity & O(n) space complexity.
 *
 * <p>Same Array: We can use the input array itself for marking indices as present. Using a
 * combination of for and while and swapping elements to put all the in range positive elements at
 * their places without losing any of them. We can simply iterate over the array after marking to
 * find the first missing number. This will take O(n) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int firstMissingPositive(int[] A) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
      while (A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1]) {
        int temp = A[i];
        A[i] = A[temp - 1];
        A[temp - 1] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      if (A[i] != i + 1) return i + 1;
    }
    return n + 1;
  }
}
