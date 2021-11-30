package com.atul.scaler.lean.arrays.sumallsubmatrices;

/**
 * Problem: Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible
 * submatrices.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <=30
 *
 * <p>0 <= A[i][j] <= 10
 *
 * <p>Input: Single argument representing a 2-D array A of size N x N.
 *
 * <p>Output: Return an integer denoting the sum of all possible submatrices in the given matrix.
 *
 * <p>Approach: We have to find the sum of all the submatrices for a square matrix.
 *
 * <p>1. Brute force: Generate all possible submatrices using indices, find their sum by iterating
 * over those indices and add to the tally. This approach involves a lot of repetitive calculations.
 *
 * <p>This will take O(n^4) time complexity & O(1) space complexity.
 *
 * <p>2. Improving upon, if we find out the occurrence of each element in the sum in constant time,
 * we get the whole sum just by iterating over all the elements.
 *
 * <p>This will take O(n^2) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int solveBruteForce(int[][] A) {
    int res = 0;
    for (int i = 0; i < A.length; i++)
      for (int j = 0; j < A[i].length; j++)
        res += A[i][j] * (i + 1) * (j + 1) * (A.length - i) * (A[i].length - j);
    return res;
  }
}
