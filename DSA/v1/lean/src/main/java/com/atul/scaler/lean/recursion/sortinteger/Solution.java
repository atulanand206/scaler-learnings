package com.atul.scaler.lean.recursion.sortinteger;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;
import java.util.Arrays;

/**
 * Problem: On the first row, we write a 0. Now in every subsequent row, we look at the previous row
 * and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * <p>Given row A and index B, return the Bth indexed symbol in row A. (The values of B are
 * 1-indexed.) (1 indexed).
 *
 * @author atulanand
 */
public class Solution {

  public String solve(int[] A) {
    recursion(A, 0, A.length - 1);
    return Arrays.toString(A);
  }

  private void recursion(int[] A, int s, int e) {
    if (s >= e) return;
    int mid = (s + e) / 2;
    recursion(A, s, mid);
    recursion(A, mid + 1, e);
    O.debug("left" + S.string(A, s, mid) + "next " + S.string(A, mid + 1, e));
    int l = mid, r = mid + 1;
    while (r <= e) {
      int i = r;
      while (l >= 0 && A[l] > 0 && A[r] < 0) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
        l--;
        r--;
      }
      l = i;
      r = i + 1;
    }
    O.debug(S.string(A, s, e));
    O.debugNewLine();
  }

  public static void main(String[] args) {
    O.attach();
    O.debug(
        S.string(
            new Solution()
                .solve(
                    new int[] {
                      12, 11, -13, -5, 6, -7, 5, -3, -6, 12, 11, -13, -5, 6, -7, 5, -3, -6
                    })));
  }
}
