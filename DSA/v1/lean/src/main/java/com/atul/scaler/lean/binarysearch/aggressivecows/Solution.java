package com.atul.scaler.lean.binarysearch.aggressivecows;

import com.atul.scaler.lean.utils.O;
import java.util.Arrays;

public class Solution {
  public int solve(int[] A, int B) {
    Arrays.sort(A);
    int s = 1, e = A[A.length - 1] - A[0];
    int ans = 0;
    while (s <= e) {
      int mid = (s + e) / 2;
      boolean valid = isValid(A, B - 1, mid);
      if (valid) {
        ans = Math.max(ans, mid);
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }
    return ans;
  }

  private boolean isValid(int[] A, int B, int x) {
    int z = A[0];
    int i = 1;
    while (i < A.length) {
      if (A[i] - z >= x) {
        B--;
        z = A[i];
        if (B == 0) return true;
      }
      i++;
    }
    return false;
  }

  public static void main(String[] args) {
    O.attach();
    System.out.println(new Solution().solve(new int[] {5, 17, 100, 11}, 2));
  }
}
