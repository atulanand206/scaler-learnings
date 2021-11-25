package com.atul.scaler.lean.arrays.maxnonnegsubarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Given an array of integers, A of length N, find out the maximum sum sub-array of non
 * negative numbers from A.
 *
 * <p>The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth
 * element and skipping the third element is invalid.
 *
 * <p>Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 *
 * <p>Find and return the required subarray.
 *
 * <p>NOTE:
 *
 * <p>1. If there is a tie, then compare with segment's length and return segment which has maximum
 * length.
 *
 * <p>2. If there is still a tie, then return the segment with minimum starting index.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 1e5
 *
 * <p>-INT_MAX < A[i] <= INT_MAX
 *
 * <p>Input: The first and the only argument of input contains an integer array A, of length N.
 *
 * <p>Output: Return an array of integers, that is a subarray of A that satisfies the given
 * conditions.
 *
 * <p>Observation:
 *
 * <p>1. If all the numbers are less than 0, the answer would simply be an empty list.
 *
 * <p>2. If the maximum number is 0, then the segment with most occurences of 0.
 *
 * <p>3. If there are some positive integers, we can break the list at all the negative numbers and
 * consider the rest of the segments.
 *
 * <p>Approach: We have to find the longest segment with largest sum not consisting of any negative
 * number.
 *
 * <p>1. Converting the array to a prefix sum while putting 0 for the negative numbers.
 *
 * <p>2. The intervals will be clear in the prefix array with values increasing for each interval
 * and 0 for others.
 *
 * <p>3. For each interval, we have the sum of elements, we can determine the max of it and only
 * change the max if a higher sum is present to ensure that the lowest index is always selected.
 *
 * <p>4. Once the max sum interval is figured out, we can return the values for that interval from
 * the original list.
 *
 * <p>This will take O(n) time complexity & O(n) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public ArrayList<Integer> maxNonNegativeSubArray(ArrayList<Integer> A) {
    if (Collections.max(A) < 0) {
      return new ArrayList<>();
    }
    if (Collections.max(A) == 0) {
      int maxC = 0, C = 0;
      for (int i : A) {
        if (i == 0) {
          C++;
        } else {
          C = 0;
        }
        maxC = Math.max(maxC, C);
      }
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < maxC; i++) result.add(0);
      return new ArrayList<>(result);
    }
    long[] sum = new long[A.size()];
    if (A.get(0) > 0) sum[0] = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      if (A.get(i) < 0) {
        sum[i] = 0;
      } else {
        sum[i] = sum[i - 1] + A.get(i);
      }
    }
    long maxSum = 0;
    int maxStart = 0, maxEnd = 0;
    int start = 0, end = 0;
    for (int i = 0; i < A.size(); i++) {
      if (sum[i] == 0) {
        start = i;
        end = i;
        continue;
      }
      if (i > 0 && sum[i] != 0) {
        if (sum[i - 1] == 0) {
          start = i;
          end = i;
        } else {
          end++;
        }
      }
      if (i == sum.length - 1 || sum[i + 1] == 0) {
        if (sum[i] > maxSum) {
          maxStart = start;
          maxEnd = end;
          maxSum = sum[i];
        }
      }
    }
    List<Integer> result = A.subList(maxStart, maxEnd + 1);
    return new ArrayList<Integer>(result);
  }
}
