package com.atul.scaler.lean.bitmanipulation.minxor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given an integer array A of N integers, find the pair of integers in the array which
 * have minimum XOR value. Report the minimum XOR value.
 *
 * @author atulanand
 */
public class Solution {
  public int findMinXor(ArrayList<Integer> A) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : A) map.merge(i, 1, Integer::sum);
    long count = map.values().stream().filter(i -> i > 1).count();
    if (count > 0) return 0;

    return res;
  }
}
