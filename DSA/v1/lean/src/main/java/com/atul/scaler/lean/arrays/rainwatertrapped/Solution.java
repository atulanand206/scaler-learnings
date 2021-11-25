package com.atul.scaler.lean.arrays.rainwatertrapped;

/**
 * Problem: Given a vector A of non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 * <p>Problem Constraints: 1 <= |A| <= 100000
 *
 * <p>Input: First and only argument is the vector A.
 *
 * <p>Output: Return one integer, the answer to the question.
 *
 * <p>Approach: We have been given a skyline of buildings and we have to find the vacant space in
 * between the adjacent buildings.
 *
 * <p>1. Water could accumulate when there are higher buildings on both sides of a building.
 *
 * <p>2. Extending that, we can say that the amount of water collected on top of a building would be
 * the min of max heights from both sides w.r.t. the building in consideration.
 *
 * <p>3. We can easily determine the prefix & suffix max array which will have the max heights from
 * left & right sides of the skyline.
 *
 * <p>4. We can compare each index values to get the amount on water on top of each building.
 *
 * <p>5. Sum it up across the skyline and we have the answer.
 *
 * <p>This will take O(n) time complexity & O(n) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int trap(final int[] A) {
    int[] lm = new int[A.length];
    lm[0] = A[0];
    for (int i = 1; i < A.length; i++) lm[i] = Math.max(lm[i - 1], A[i]);
    int result = 0, right_max = A[A.length - 1];
    for (int i = A.length - 2; i > 0; i--) {
      int min = Math.min(right_max, lm[i - 1]);
      if (min > A[i]) result += min - A[i];
      right_max = Math.max(right_max, A[i]);
    }
    return result;
  }
}
