package com.atul.scaler.lean.arrays.minswaps;

/**
 * Problem: Given an array of integers A and an integer B, find and return the minimum number of
 * swaps required to bring all the numbers less than or equal to B together.
 *
 * <p>Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= length of the array <= 100000
 *
 * <p>-10^9 <= A[i], B <= 10^9
 *
 * <p>Input: The first argument given is the integer array A. The second argument given is the
 * integer B.
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
  public int solve(int[] A, int B) {
    int tot = 0;
    for (int i = 0; i < A.length; i++) if (A[i] <= B) tot++;
    int ans = 0;
    int cnt = 0;
    for (int i = 0; i < tot; i++) if (A[i] <= B) cnt++;
    for (int i = tot; i < A.length; i++) {
      if (A[i] <= B) cnt++;
      if (A[i - tot] <= B) cnt--;
      ans = Math.max(ans, cnt);
    }
    return tot - ans;
  }
}
