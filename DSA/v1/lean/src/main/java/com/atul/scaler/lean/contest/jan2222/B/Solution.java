package com.atul.scaler.lean.contest.jan2222.B;

import static com.atul.scaler.lean.utils.O.debug;
import static com.atul.scaler.lean.utils.S.string;

import com.atul.scaler.lean.utils.O;
import java.util.*;

/** @author atulanand */
public class Solution {

  private static final int MOD = (int) 1E9 + 7;

  public int solve(int[] a) {
    long[] A = new long[a.length];
    for (int i = 0; i < A.length; i++) A[i] = a[i];
    long ans = 0;
    long subsum = 0;
    for (int i = 0; i < A.length; i++) {
      subsum += (long) (A.length - i) * A[i];
      subsum %= MOD;
    }
    long addsum = 0;
    for (int i = 0; i < A.length; i++) {
      addsum += (long) (i + 1) * A[i];
      addsum %= MOD;
    }
    Map<Long, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      Set<Integer> set = map.getOrDefault(A[i], new HashSet<>());
      set.add(i);
      map.put(A[i], set);
    }
    Map<Long, List<Integer>> map2 = new HashMap<>();
    for (Map.Entry<Long, Set<Integer>> entry : map.entrySet()) {
      List<Integer> lst = new ArrayList<>(entry.getValue());
      Collections.sort(lst);
      map2.put(entry.getKey(), lst);
    }
    debug(string(map));
    long cnt = 0;
    for (int j = 0; j < A.length; j++) {
      long x = 0;
      x += findI(map2, A[j] - 1, j);
      x += findI(map2, A[j], j);
      x += findI(map2, A[j] + 1, j);
      cnt = (cnt + x * A[j]) % MOD;
    }

    long cnt1 = 0;
    for (int i = 0; i < A.length; i++) {
      long x = 0;
      x += findJ(map2, A[i] - 1, i);
      x += findJ(map2, A[i], i);
      x += findJ(map2, A[i] + 1, i);
      cnt1 = (cnt1 + x * A[i]) % MOD;
    }
    ans = (addsum - cnt) - (subsum - cnt1) % MOD;
    ans = (ans + MOD) % MOD;
    return (int) ans;
  }

  private static int findI(Map<Long, List<Integer>> map, long idx, int upper) {
    List<Integer> lst = map.getOrDefault(idx, new ArrayList<>());
    if (lst.size() == 0) return 0;
    if (lst.get(0) > upper) return 0;
    if (lst.get(lst.size() - 1) < upper) return lst.size();
    int s = 0, e = lst.size() - 1;
    int ans = 0;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (lst.get(mid) <= upper) {
        ans = Math.max(ans, mid);
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }
    return ans + 1;
  }

  private static int findJ(Map<Long, List<Integer>> map, long idx, int lower) {
    List<Integer> lst = map.getOrDefault(idx, new ArrayList<>());
    if (lst.size() == 0) return 0;
    if (lst.get(0) > lower) return lst.size();
    if (lst.get(lst.size() - 1) < lower) return 0;
    int s = 0, e = lst.size() - 1;
    int ans = lst.size();
    while (s <= e) {
      int mid = (s + e) / 2;
      if (lst.get(mid) >= lower) {
        ans = Math.min(ans, mid);
        e = mid - 1;
      } else {
        s = mid + 1;
      }
    }
    return ans + 1;
  }

  public static void main(String[] args) {
    O.attach();
    debug(string(new Solution().solve(new int[] {1, 2, 3})));
    debug(string(new Solution().solve(new int[] {4, 2, 5, 1})));
    debug(string(new Solution().solve(new int[] {4, 4, 6, 7, 8})));
  }
}
