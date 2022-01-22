package com.atul.scaler.lean.binarysearch.matrixmedian;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

public class Solution {
  public int findMedian(int[][] A) {
    int mdn = (A.length * A[0].length + 1) / 2;
    int s = 1, e = maxOf(A);
    O.debug(S.string(mdn));
    int ans = 0;
    while (s <= e) {
      int mid = (s + e) / 2;
      O.debug(S.string(mid + " " + lessOrEqual(A, mid - 1) + " " + lessOrEqual(A, mid)));
      if (lessOrEqual(A, mid - 1) < mdn && lessOrEqual(A, mid) >= mdn) return mid;
      if (lessOrEqual(A, mid - 1) >= mdn) e = mid - 1;
      else s = mid + 1;
    }
    return ans;
  }

  private int lessOrEquals(int[] A, int t) {
    if (t < A[0]) return 0;
    if (t > A[A.length - 1]) return A.length;
    int s = 0, e = A.length - 1;
    int ans = 0;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (A[mid] <= t) {
        ans = Math.max(ans, mid);
        s = mid + 1;
      } else e = mid - 1;
    }
    return ans + 1;
  }

  private int lessOrEqual(int[][] A, int t) {
    int z = 0;
    for (int[] i : A) z += lessOrEquals(i, t);
    return z;
  }

  private int maxOf(int[][] A) {
    int z = 0;
    for (int[] i : A) z = Math.max(z, i[i.length - 1]);
    return z;
  }

  public static void main(String[] args) {
    O.attach();
    System.out.println(new Solution().findMedian(new int[][] {{1, 1, 1, 2, 3}}));
  }
}
