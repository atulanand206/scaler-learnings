package com.atul.scaler.lean.arrays.submatrixsumqueries;

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
  private static int MOD = (int) 1E9 + 7;

  public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
    int rows = A.length;
    int columns = A[0].length;
    long[][] pf = new long[rows][columns];
    for (int i = 0; i < rows; i++) pf[i][0] = A[i][0];
    for (int i = 0; i < rows; i++)
      for (int j = 1; j < columns; j++) pf[i][j] = (pf[i][j - 1] + A[i][j]);
    for (int i = 1; i < rows; i++)
      for (int j = 0; j < columns; j++) pf[i][j] = (pf[i - 1][j] + pf[i][j]);
    for (int i = 0; i < rows; i++) for (int j = 0; j < columns; j++) pf[i][j] = pf[i][j] % MOD;
    int[] res = new int[B.length];
    for (int i = 0; i < res.length; i++) {
      int bottomRightY = E[i] - 1;
      int bottomRightX = D[i] - 1;
      int topLeftY = C[i] - 1;
      int topLeftX = B[i] - 1;
      long sumBR =
          (bottomRightX < rows && bottomRightY < columns) ? pf[bottomRightX][bottomRightY] : 0;
      long sumTL =
          ((topLeftX >= 1 && topLeftY >= 1 && topLeftX - 1 < rows && topLeftY - 1 < columns)
              ? pf[topLeftX - 1][topLeftY - 1]
              : 0);
      long sumTR =
          ((topLeftX >= 1 && topLeftX - 1 < rows && bottomRightY < columns)
              ? pf[topLeftX - 1][bottomRightY]
              : 0);
      long sumBL =
          ((topLeftY >= 1 && bottomRightX < rows && topLeftY - 1 < columns)
              ? pf[bottomRightX][topLeftY - 1]
              : 0);
      res[i] = (int) (((sumBR - sumTR) % MOD - (sumBL - sumTL) % MOD) % MOD);
      if (res[i] < 0) res[i] = (MOD + res[i]) % MOD;
    }
    return res;
  }
}
