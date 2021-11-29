package com.atul.scaler.lean.arrays.flip;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem: You are given a binary string A(i.e. with characters 0 and 1) consisting of characters
 * A1, A2, …, AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N
 * and flip the characters AL, AL+1, …, AR. By flipping, we mean change character 0 to 1 and
 * vice-versa.
 *
 * <p>Your aim is to perform ATMOST one operation such that in final string number of 1s is
 * maximised.
 *
 * <p>If you don't want to perform the operation, return an empty array. Else, return an array
 * consisting of two elements denoting L and R. If there are multiple solutions, return the
 * lexicographically smallest pair of L and R.
 *
 * <p>NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b <
 * d.
 *
 * <p>Problem Constraints: 1 <= size of string <= 100000
 *
 * <p>Input: First and only argument is a string A.
 *
 * <p>Return: Return an array of integers denoting the answer.
 *
 * <p>Approach: We have to find the sub array which will be flipped to get most 1s in the string.
 *
 * <p>1. Trivial case: If there are all 1s, we can't increase any more.
 *
 * <p>2. If there is a 0 present, the answer can be found in a single pass with the help of some
 * variables.
 *
 * <p>3. In each iteration, we check the value. If the value is 0, we increase the possible sum and
 * vice-versa.
 *
 * <p>4. We keep track of the start index of the subarray and use the current index as the end index
 * of the subarray.
 *
 * <p>5. If current sum is higher, we found a better solution.
 *
 * <p>6. Repeat for all the indices and we've the subarray which will make most 1s in the solution.
 *
 * <p>This will take O(N) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {

  public ArrayList<Integer> flip(String A) {
    if (Arrays.stream(A.split("")).filter(ch -> ch.equals("1")).count() == A.length())
      return new ArrayList<>();
    int start = 0, max = 0, sum = 0, max_start = 0, max_end = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '0') {
        sum++;
        if (sum > max) {
          max = sum;
          max_start = start;
          max_end = i + 1;
        }
      } else {
        // means 1
        sum--;
        if (sum < 0) {
          // discard this case
          sum = 0;
          start = i + 1;
        }
      }
    }
    ArrayList<Integer> lst = new ArrayList<>();
    lst.add(max_start + 1);
    lst.add(max_end);
    return lst;
  }
}
