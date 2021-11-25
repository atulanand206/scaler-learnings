package com.atul.scaler.lean.arrays.maxabsdiff;

import java.util.ArrayList;

/**
 * Problem: You are given an array of N integers, A1, A2, …. AN. Return the maximum value of f(i, j)
 * for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute
 * value of x.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 100000
 *
 * <p>-10^9 <= A[i] <= 10^9
 *
 * <p>Input: First argument is an integer array A of size N.
 *
 * <p>Output: Return an integer denoting the maximum value of f(i, j).
 *
 * <p>Approach: 1.We have to find the max of |A[i] - A[j]| + |i - j| across all values of i & j.
 *
 * <p>2. In algebra, |x| is usually expanded across the x-axis at origin.
 *
 * <p>3. The value stays as is on the positive side while it's multiplied by -1 when negative.
 *
 * <p>4. Formally, |x| = x ; if x >= 0 and |x| = -x ; if x < 0
 *
 * <p>5. Using this property, we must boil down the equation to simpler terms before we can
 * determine the answer.
 *
 * <p>Case 1: i > j: |i - j| = i - j
 *
 * <p>Our equation |A[i] - A[j]| + |i - j| becomes |A[i] - A[j]| + i - j
 *
 * <p>1.1. A[i] - A[j] + i - j => (A[i] + i) - (A[j] + j)
 *
 * <p>1.2. A[j] - A[i] + i - j => (A[j] - j) - (A[i] - i)
 *
 * <p>Case 2: i < j: |i - j| = j - i
 *
 * <p>Our equation |A[i] - A[j]| + |i - j| becomes |A[i] - A[j]| + j - i
 *
 * <p>2.1. A[i] - A[j] + j - i => (A[i] - i) - (A[j] - j)
 *
 * <p>2.2. A[j] - A[i] + j - i => (A[j] + j) - (A[i] + i)
 *
 * <p>6. Equations
 *
 * <p>6.1. (A[i] + i) - (A[j] + j)
 *
 * <p>6.2. (A[j] - j) - (A[i] - i)
 *
 * <p>7. We have to find the maximum values that these equations take for all the pairs of indices.
 *
 * <p>8. For maximizing a equation similar to a - b, we can maximize a & minimize b.
 *
 * <p>9. Since all pairs have to be considered, if we can get the values (a[i] - i) & (a[i] + i) and
 * just use the maximum and minimum values across all indices in our broken down equations.
 *
 * <p>10. We can find the max & min values either separately using Collections API or iteration,
 * even single pass could do.
 *
 * <p>This will take O(n) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int maxArr(ArrayList<Integer> A) {
    int maxMinus = Integer.MIN_VALUE,
        minMinus = Integer.MAX_VALUE,
        maxPlus = Integer.MIN_VALUE,
        minPlus = Integer.MAX_VALUE;
    for (int i = 0; i < A.size(); i++) {
      maxPlus = Math.max(maxPlus, A.get(i) + i);
      minPlus = Math.min(minPlus, A.get(i) + i);
      maxMinus = Math.max(maxMinus, A.get(i) - i);
      minMinus = Math.min(minMinus, A.get(i) - i);
    }
    return Math.max(maxPlus - minPlus, maxMinus - minMinus);
  }
}
