package com.atul.scaler.lean.arrays.minswaps2;

/**
 * Problem: Given an array of integers A of size N that is a permutation of [0, 1, 2, …, (N-1)]. It
 * is allowed to swap any two elements (not necessarily consecutive).
 *
 * <p>Find the minimum number of swaps required to sort the array in ascending order.
 *
 * <p>Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 100000
 *
 * <p>0 <= A[i] < N
 *
 * <p>Input: The only argument given is the integer array A.
 *
 * <p>Output: Return the minimum number of swaps.
 *
 * <p>Approach:
 *
 * <p>This will take O(n) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int solve(int[] A) {
    int cnt = 0, i = 0;
    while (i < A.length) {
      if (A[i] != i) {
        while (A[i] != i && A[i] > 0) {
          int temp = A[A[i]];
          A[A[i]] = A[i];
          A[i] = temp;
          cnt++;
        }
      }
      i++;
    }
    return cnt;
  }
}
