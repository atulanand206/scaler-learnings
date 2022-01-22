package com.atul.scaler.lean.twopointers.sumzero3;

import static com.atul.scaler.lean.utils.O.*;
import static com.atul.scaler.lean.utils.S.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private static int MOD = (int) 1E9 + 7;

  public int[][] threeSum(int[] A) {
    Arrays.sort(A);
    debug(string(A));
    List<int[]> items = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      find2(A, items, i + 1, -A[i]);
      while (i < A.length - 1 && A[i] == A[i + 1]) i++;
    }
    int[][] res = new int[items.size()][];
    int i = 0;
    for (int[] item : items) {
      res[i++] = item;
    }
    return res;
  }

  private void find2(int[] A, List<int[]> items, int from, int what) {
    int s = from, e = A.length - 1;
    while (s < e) {
      int sum = A[s] + A[e];
      if (sum == what) {
        items.add(build(-what, A[s], A[e]));
        while (s < A.length - 1 && A[s] == A[s + 1]) s++;
        s++;
        while (e > 0 && A[e] == A[e - 1]) e--;
        e--;
      } else if (sum < what) {
        s++;
      } else {
        e--;
      }
    }
  }

  private int getI(int[] A, List<int[]> items, int i) {
    for (int j = i + 1; j < A.length; j++) {
      for (int k = j + 1; k < A.length; k++) {
        if (A[i] + A[j] + A[k] == 0) {
          items.add(build(A[i], A[j], A[k]));
          while (i < A.length - 3 && A[i] == A[i + 1]) i++;
          while (j < A.length - 2 && A[j] == A[j + 1]) j++;
          while (k < A.length - 1 && A[k] == A[k + 1]) k++;
        }
      }
    }
    return i;
  }

  private int[] build(int a, int a1, int b) {
    int min = Math.min(a, Math.min(a1, b));
    int max = Math.max(a, Math.max(a1, b));
    int mid = a ^ a1 ^ b ^ min ^ max;
    debug(string(new int[] {min, mid, max}));
    return new int[] {min, mid, max};
  }

  public int[][] threeSumBruteForce(int[] A) {
    Arrays.sort(A);
    List<int[]> items = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      i = getI(A, items, i);
    }
    int[][] res = new int[items.size()][];
    int i = 0;
    for (int[] item : items) {
      res[i++] = item;
    }
    return res;
  }

  public static void main(String[] args) {
    attach();
    int[] arr = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
    System.out.println(Arrays.deepToString(new Solution().threeSumBruteForce(arr)));
    debugN();
    System.out.println(Arrays.deepToString(new Solution().threeSum(arr)));
  }
}
