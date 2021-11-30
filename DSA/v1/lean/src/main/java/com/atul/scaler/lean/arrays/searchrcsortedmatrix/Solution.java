package com.atul.scaler.lean.arrays.searchrcsortedmatrix;

/**
 * Problem: Given a matrix of integers A of size N x M and an integer B. In the given matrix every
 * row and column is sorted in increasing order.
 *
 * <p>Find and return the position of B in the matrix in the given form:
 *
 * <p>If A[i][j] = B then return (i * 1009 + j)
 *
 * <p>If B is not present return -1.
 *
 * <p>Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 * <p>Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that
 * A[i][j]=B.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N, M <= 1000
 *
 * <p>-100000 <= A[i] <= 100000
 *
 * <p>-100000 <= B <= 100000
 *
 * <p>Input: The first argument given is the integer matrix A. The second argument given is the
 * integer B.
 *
 * <p>Output: Return the position of B and if it is not present in A return -1 instead.
 *
 * <p>Approach: We have to find the position of an integer in the matrix. The problem also states
 * that there are duplicate entries. There is no option to find the smallest value other than to
 * iterate over all elements.
 *
 * <p>1. Brute force: We iterate through all the cells of the matrix and return if the value is
 * present.
 *
 * <p>This will take O(n * m) time complexity & O(1) space complexity.
 *
 * <p>2. Observations if there are distinct elements guaranteed:
 *
 * <p>2.1. The rows and cols are sorted in increasing order.
 *
 * <p>2.2. We can compare the integer with a cell and decide on where the element would exist
 * relative to it.
 *
 * <p>3. All the points on the other diagonal possess a property, viz., if a value is smaller, it
 * can never be present in the col as all values in the col are higher and hence, we can eliminate
 * the col altogether.
 *
 * <p>4. Starting from the top-right cell we can eliminate rows or cols and determine if the integer
 * is present.
 *
 * <p>5. Eliminating the cols first, if the cell value is greater than the integer, we shift one
 * cell left. If the value is equal or less, stop the loop.
 *
 * <p>6. Eliminating the rows next, if the cell value is smaller than the integer, we shift one cell
 * down. If the value is equal or less, stop the loop.
 *
 * <p>7. If the value is equal, we found the integer else it doesn't exist because the cell value
 * would be lower.
 *
 * <p>This will take O(n) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  public int solveIfAllElementsDistinct(int[][] A, int B) {
    if (A[0][0] > B || A[A.length - 1][A[0].length - 1] < B) return -1;
    int i = 0;
    int j = A[i].length - 1;
    while (i < A.length && j >= 0) {
      if (A[i][j] == B) return 1009 * (i + 1) + (j + 1);
      if (j > 0 && A[i][j] > B && A[i][j - 1] < B) return -1;
      if (A[i][j] > B && j > 0) j--;
      if (A[i][j] < B && i < A.length - 1) i++;
    }
    return -1;
  }

  public int solveBruteForce(int[][] A, int B) {
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++)
      for (int j = 0; j < A[i].length; j++)
        if (A[i][j] == B) res = Math.min(res, 1009 * (i + 1) + (j + 1));
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
