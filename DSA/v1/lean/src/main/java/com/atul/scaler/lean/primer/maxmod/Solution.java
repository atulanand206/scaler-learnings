package com.atul.scaler.lean.primer.maxmod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Problem: Given an array A of size N, groot wants you to pick 2 indices i and j such that
 *
 * <p>1. 1 <= i
 *
 * <p>2. j <= N
 *
 * <p>3. A[i] % A[j] is maximum among all possible pairs of (i, j).
 *
 * <p>Help Groot in finding the maximum value of A[i] % A[j] for some i, j.
 *
 * <p>Constraints:
 *
 * <p>1 <= N <= 100000
 *
 * <p>0 <= A[i] <= 100000
 *
 * <p>Input: First and only argument in an integer array A.
 *
 * <p>Output: Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.
 *
 * <p>Approach:
 *
 * <p>1. A number when divided by a number larger than itself, the modulo will be equal to the
 * number itself.
 *
 * <p>2. Mod of number with itself is 0. Hence, we need to two numbers for getting a positive
 * modulo. The case of duplication is handled by using a set for the next step.
 *
 * <p>3. Intuitively, if A[i] becomes the second largest number, and A[j] will be the largest
 * number, their mod will be equal to the second largest number. If the order is reversed, the
 * modulo will definitely be smaller than the second largest number.
 *
 * <p>4. It is also possible that only same number is present in the array. In that case, the only
 * option is to take modulo with itself resulting in 0 modulo.
 *
 * <p>5. The answer is either 0 or the second largest number.
 *
 * @author Atul Anand
 */
public class Solution {

  public int solve(int[] A) {
    Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
    for (int i : A) set.add(i);
    List<Integer> list = new ArrayList<>(set);
    if (list.size() == 1) return 0;
    return list.get(1);
  }
}
