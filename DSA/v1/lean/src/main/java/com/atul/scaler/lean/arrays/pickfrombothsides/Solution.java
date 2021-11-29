package com.atul.scaler.lean.arrays.pickfrombothsides;

import java.util.ArrayList;

/**
 * Problem: Given an integer array A of size N.
 *
 * <p>You can pick B elements from either left or right end of the array A to get maximum sum. Find
 * and return this maximum possible sum.
 *
 * <p>NOTE: Suppose B = 4 and array A contains 10 elements then
 *
 * <p>You can pick first four elements or can pick last four elements or can pick 1 from front and 3
 * from back etc . you need to return the maximum possible sum of elements you can pick.
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= N <= 10^5
 *
 * <p>1 <= B <= N
 *
 * <p>-10^3 <= A[i] <= 10^3
 *
 * <p>Input:
 *
 * <p>First argument is an integer array A.
 *
 * <p>Second argument is an integer B.
 *
 * <p>Output:
 *
 * <p>Return an integer denoting the maximum possible sum of elements you picked.
 *
 * <p>Approach: We have to find the max possible sum of a sub array of size B containing atleast one
 * element from either side.
 *
 * <p>1. We can find the sum of last subarray and store it as a possible sum.
 *
 * <p>2. We can move one step on the right in a cyclic manner until the first subarray of the array
 * is selected.
 *
 * <p>3. In the whole traversal, we have all the possible sums and that helps in determining the max
 * possible sum.
 *
 * <p>4. This will take O(B) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {

  public int solve(ArrayList<Integer> A, int B) {
    int sum = A.stream().skip(A.size() - B).reduce(0, Integer::sum);
    int ans = sum;
    for (int i = 0; i < B; i++) {
      sum += A.get(i) - A.get(A.size() - B + i);
      ans = Math.max(ans, sum);
    }
    return ans;
  }
}
