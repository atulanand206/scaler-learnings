package com.atul.scaler.lean.arrays.maxsumsquaresubmatrix;

/**
 * Problem: Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1,
 * such that sum of all the elements in submatrix is maximum.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 10^3
 *
 * <p>1 <= B <= N
 *
 * <p>-10^2 <= A[i][j] <= 10^2
 *
 * <p>Input: First argument is an 2D integer matrix A. Second argument is an integer B.
 *
 * <p>Output: Return a single integer denoting the maximum sum of submatrix of size B x B.
 *
 * <p>Approach: We have to find the max sum of submatrix of a fixed size.
 *
 * <p>1.Observations:
 *
 * <p>1.1. A submatrix requires two points to locate in a matrix. Top-Left & Bottom-Right or
 * Top-Right & Bottom-Left.
 *
 * <p>1.2. In the problem, we only have to consider the submatrices of fixed size, viz., the two
 * points are fixed relative to each other and now we require only one point to locate a submatrix.
 *
 * <p>1.3. Sum of a submatrix can be calculated in O(1) time complexity using a prefix sum matrix.
 *
 * <p>2. For each cell in the matrix which can act as the Top-Left of the submatrix within the
 * bounds of fixed size, we find the sum using the prefix sum matrix and find its max value.
 *
 * <p>This will take O(n^2) time complexity & O(n^2) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int solve(int[][] A, int B) {
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++)
      for (int j = 1; j < A.length; j++) A[i][j] = A[i][j - 1] + A[i][j];
    for (int i = 1; i < A.length; i++)
      for (int j = 0; j < A.length; j++) A[i][j] = A[i - 1][j] + A[i][j];
    for (int i = -1; i + B < A.length; i++)
      for (int j = -1; j + B < A.length; j++)
        res =
            Math.max(
                res,
                A[i + B][j + B]
                    - (i >= 0 ? A[i][j + B] : 0)
                    - (j >= 0 ? A[i + B][j] : 0)
                    + ((i >= 0 && j >= 0) ? A[i][j] : 0));
    return res;
  }
}
