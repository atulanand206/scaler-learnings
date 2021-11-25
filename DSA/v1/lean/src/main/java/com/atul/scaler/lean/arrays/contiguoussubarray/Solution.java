package com.atul.scaler.lean.arrays.contiguoussubarray;

import java.util.List;

/**
 * Problem: Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 1e6
 *
 * <p>-1000 <= A[i] <= 1000
 *
 * <p>Input: The first and the only argument contains an integer array, A.
 *
 * <p>Output: Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 * <p>Approach: This problem is a simplification of the maximum non-negative subarray and becomes
 * cleaner as we're only concerned with the largest sum and not the subarray itself.
 *
 * <p>1. As we've to consider all the numbers, instead of marking the negative items as 0, we'll
 * keep them as is.
 *
 * <p>2. In a single pass through, we can keep track of the maximum sum till current index in a
 * variable.
 *
 * <p>3. Additionally, we've to track the segment sum. Another variable to store the sum which
 * includes the current index value.
 *
 * <p>4. Whenever a segment sum becomes negative, the segment is over and we can set the segment sum
 * to 0 for the next segment.
 *
 * <p>5. At each step, if the segment sum exceeds the max sum, we can set the segment sum as the max
 * sum.
 *
 * <p>6. Iterating for all the indices will give the value of max sub array sum.
 *
 * <p>This will take O(n) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int maxSubArray(final List<Integer> A) {
    int size = A.size();
    int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
    for (int i = 0; i < size; i++) {
      maxEndingHere = maxEndingHere + A.get(i);
      if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
      if (maxEndingHere < 0) maxEndingHere = 0;
    }
    return maxSoFar;
  }
}
