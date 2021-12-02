package com.atul.scaler.lean.arrays.spiralordermatrix;

/**
 * Problem: Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral
 * order.
 *
 * <p>Problem Constraints: 1 <= A <= 1000
 *
 * <p>Input: First and only argument is integer A
 *
 * <p>Output: Return a 2-D matrix which consists of the elements in spiral order.
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
  public enum LastVertex {
    TOP_LEFT,
    TOP_RIGHT,
    BOTTOM_RIGHT,
    BOTTOM_LEFT
  }

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int i = 0, j = 0, value = 1;
    LastVertex lastVertex = LastVertex.TOP_LEFT;
    while (i >= 0 && i < n && j >= 0 && j < n && matrix[i][j] == 0) { // n = 4, i = 2 , j =2
      matrix[i][j] = value++;
      switch (lastVertex) {
        case TOP_LEFT:
          if (j + 1 == n || matrix[i][j + 1] != 0) {
            lastVertex = LastVertex.TOP_RIGHT;
            i++;
          } else {
            j++;
          }
          break;
        case TOP_RIGHT:
          if (i + 1 == n || matrix[i + 1][j] != 0) {
            lastVertex = LastVertex.BOTTOM_RIGHT;
            j--;
          } else {
            i++;
          }
          break;
        case BOTTOM_RIGHT:
          if (j - 1 == -1 || matrix[i][j - 1] != 0) {
            lastVertex = LastVertex.BOTTOM_LEFT;
            i--;
          } else {
            j--;
          }
          break;
        case BOTTOM_LEFT:
          if (i - 1 == -1 || matrix[i - 1][j] != 0) {
            lastVertex = LastVertex.TOP_LEFT;
            j++;
          } else {
            i--;
          }
      }
    }
    return matrix;
  }
}
