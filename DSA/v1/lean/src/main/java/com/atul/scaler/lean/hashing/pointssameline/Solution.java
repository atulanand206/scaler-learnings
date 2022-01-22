package com.atul.scaler.lean.hashing.pointssameline;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

/** @author atulanand */
public class Solution {

  public int solve(int[] A, int[] B) {
    if (A.length == 1) return 1;
    O.debug(A[17] + ", " + B[17] + "\n");
    O.debug(A[27] + ", " + B[27] + "\n");
    int ans = 2;
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (i == j) continue;
        int cnt = 2;
        for (int k = 0; k < A.length; k++) {
          if (k == i || k == j) continue;
          if (A[i] == A[j] && B[i] == B[j]) continue;
          if (isCollinear(A, B, i, j, k)) {
            cnt++;
          }
        }
        O.debug(i + " " + j + " " + cnt + "\n");
        ans = Math.max(ans, cnt);
      }
    }
    return ans;
  }

  private boolean isCollinear(int[] A, int[] B, int a, int b, int c) {
    int area = A[a] * (B[b] - B[c]) + A[b] * (B[c] - B[a]) + A[c] * (B[a] - B[b]);
    //    O.debug(a + " " + b + " " + c + " " + (area == 0 ? area : "") + "\n");
    return area == 0;
  }

  public static void main(String[] args) {
    O.attach();
    O.debug(
        S.string(
            new Solution()
                .solve(
                    new int[] {
                      -44, 44, 32, -43, -41, 18, -29, 49, 19, 28, 26, 29, 39, -4, 2, -36, 6, -45,
                      -17, 16, -9, 34, 20, -48, -21, -19, -28, -45, -8, 8, 13, -42, -35, 15, -12,
                      -36, 42, 24, 41
                    },
                    new int[] {
                      40, -9, -31, 43, 33, -34, -40, 25, 32, -5, 34, 41, -11, 24, -31, 9, -27, -20,
                      -40, 35, -44, 29, 45, 40, 40, 33, -33, -20, -11, 20, -7, -28, 48, -44, 3, 39,
                      26, 21, 8
                    })));
  }
}
