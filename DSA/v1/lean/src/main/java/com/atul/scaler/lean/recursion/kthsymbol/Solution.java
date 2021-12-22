package com.atul.scaler.lean.recursion.kthsymbol;

import java.util.ArrayList;
import java.util.List;

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

  public int solve(int A, int B) {
    List<Integer> row = new ArrayList<>();
    row.add(0);
    return d(row, A - 1).get(B - 1);
  }

  private List<Integer> d(List<Integer> r, int A) {
    if (A == 0) return r;
    List<Integer> res = new ArrayList<>();
    for (int i : r) {
      res.add(i);
      res.add(1 - i);
    }
    return d(res, A - 1);
  }
}
