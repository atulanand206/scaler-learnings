package com.atul.scaler.lean.binarysearch.bitonic;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

public class Solution {
  public int solve(int[] A, int B) {
    int gm = globalMaxima(A);
    O.debug(S.string(gm));
    if (B > A[gm] || B < Math.min(A[0], A[A.length - 1])) return -1;
    return Math.max(searchLeft(A, B, gm), searchRight(A, B, gm));
  }

  private int searchLeft(int[] A, int B, int r) {
    int s = 0, e = r;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (A[mid] == B) return mid;
      if (A[mid] > B) e = mid - 1;
      else s = mid + 1;
    }
    return -1;
  }

  private int searchRight(int[] A, int B, int l) {
    int s = l, e = A.length - 1;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (A[mid] == B) return mid;
      if (A[mid] < B) e = mid - 1;
      else s = mid + 1;
    }
    return -1;
  }

  private int globalMaxima(int[] A) {
    int s = 0, e = A.length - 1;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
      if (A[mid] > A[mid - 1]) s = mid + 1;
      else e = mid - 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .solve(
                new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11},
                12));
  }
}
