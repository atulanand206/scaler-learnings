package com.atul.scaler.lean.primer.areaunderhills;

import java.util.Arrays;

/**
 * Problem: Rishik likes to draw a lot. He starts at origin and chooses a single Y ordinate of each
 * abscissa in [1-N] given in array A and then chooses 0 for N+1. He then joins each consecutive
 * point with a straight line and found that he has drawn a masterpiece. But, It is incomplete
 * without coloring.
 *
 * <p>Requirement: So, he wants you to tell him the area of hills that he will color.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 2e5
 *
 * <p>1 <= A[i] <= 2e9
 *
 * <p>Input: First and only argument of input contains a single integer array A.
 *
 * <p>Output: Return a string denoting area of hills(with truncated/rounded down decimal).
 *
 * @author atulanand
 */
public class Solution {

  public String solve(int[] A) {
    return String.valueOf((long) Arrays.stream(A).mapToDouble(Double::valueOf).sum());
  }
}
