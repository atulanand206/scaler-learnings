package com.atul.scaler.lean.contest.jan2222.A;

import static com.atul.scaler.lean.utils.O.debug;
import static com.atul.scaler.lean.utils.S.string;

import com.atul.scaler.lean.utils.O;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author atulanand */
public class Solution {

  public int[] solve(int[] A, int[][] B) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      List<Integer> list = map.getOrDefault(A[i], new ArrayList<>());
      list.add(i);
      map.put(A[i], list);
    }
    Map<Integer, List<Integer>> also = new HashMap<>();
    for (int key : map.keySet()) {
      List<Integer> op = new ArrayList<>();
      op.add(key);
      also.put(key, op);
    }
    for (int[] q : B) {
      List<Integer> from = also.getOrDefault(q[0], new ArrayList<>());
      List<Integer> to = also.getOrDefault(q[1], new ArrayList<>());
      to.addAll(from);
      also.remove(q[0]);
      also.put(q[1], to);
      debug(string(also));
    }
    for (Map.Entry<Integer, List<Integer>> entry : also.entrySet()) {
      for (int key : entry.getValue()) for (int i : map.get(key)) A[i] = entry.getKey();
    }
    return A;
  }

  public static void main(String[] args) {
    O.attach();
    debug(
        string(
            new Solution()
                .solve(
                    new int[] {2, 2, 5, 1},
                    new int[][] {
                      {2, 4},
                      {5, 2}
                    })));

    debug(
        string(
            new Solution()
                .solve(
                    new int[] {2, 2, 5, 1},
                    new int[][] {
                      {3, 2}, {5, 5}, {2, 4}, {3, 2}, {5, 2},
                    })));

    debug(
        string(
            new Solution()
                .solve(
                    new int[] {5, 1, 3, 1},
                    new int[][] {
                      {1, 5},
                      {5, 3}
                    })));
  }
}
