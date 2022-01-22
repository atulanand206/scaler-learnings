package com.atul.scaler.lean.twopointers.pairclosesttox;

import static com.atul.scaler.lean.utils.O.*;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private static int MOD = (int) 1E9 + 7;

  private static class Pair {
    int s;
    int e;

    static Pair of(int s, int e) {
      Pair p = new Pair();
      p.s = s;
      p.e = e;
      return p;
    }
  }

  public int[] solve(int[] Ar, int[] Br, int Cr) {
    long[] A = new long[Ar.length];
    for (int i = 0; i < A.length; i++) A[i] = Ar[i];
    long[] B = new long[Br.length];
    for (int i = 0; i < B.length; i++) B[i] = Br[i];
    long C = Cr;
    long diff = Integer.MAX_VALUE;
    List<Pair> matches = new ArrayList<>();
    long a = -1, b = -1;
    int ai = -1, bi = -1;
    int s = 0, e = B.length - 1;
    while (s < A.length && e >= 0) {
      long df = Math.abs(A[s] + B[e] - C);
      O.debug(S.string(s + " " + e + " " + df));
      if (df < diff) {
        diff = df;
        matches.clear();
        matches.add(Pair.of(s, e));
        a = A[s];
        b = B[e];
        ai = s;
        bi = e;
      }
      if (diff == 0) {
        a = A[s];
        b = B[e];
        //                ai = s;
        //                bi = e;
        break;
      }
      if (A[s] + B[e] < C) {
        s++;
      } else {
        e--;
      }
    }
    return new int[] {Ar[ai], Br[bi]};
    //    long sum = a + b;
    // if (B[0] < A[0]) {
    //     long[] temp = A;
    //     A = B;
    //     B = temp;
    // }
    // s = 0;
    // e = 0;
    // while (s < A.length && e < B.length) {
    //     long pairSum = A[s] + B[e];
    //     if (pairSum == sum) {
    //         return new int[] {Ar[s], Br[e]};
    //     }
    //     if (A[s] < B[e]) {
    //         s++;
    //     } else {
    //         e++;
    //     }
    // }
    //    for (int i = 0; i < A.length; i++) {
    //      for (int j = 0; j < B.length; j++) {
    //        if (A[i] + B[j] == sum)
    //          return new int[]{Ar[i], Br[j]};
    //      }
    //    }
    //    return new int[]{(int) sum};
  }

  public static void main(String[] args) {
    attach();
    //        System.out.println(Arrays.toString(new Solution().solve(new int[]{1, 2, 3, 4, 5}, new
    // int[]{2, 4, 6, 8}, 9)));
    System.out.println(Arrays.toString(new Solution().solve(new int[] {1}, new int[] {2, 4}, 4)));
  }
}
