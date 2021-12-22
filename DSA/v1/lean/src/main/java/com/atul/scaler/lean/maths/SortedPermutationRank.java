package com.atul.scaler.lean.maths;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedPermutationRank {

  private static final int MOD = 1000003;

  public int findRank(String A) {
    String[] chars = A.split("");
    List<String> sortedChars = Arrays.stream(chars).sorted().collect(Collectors.toList());
    long ans = 0;
    int[] cnt = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
      if (sortedChars.size() == 1) {
        ans += 1;
        break;
      }
      int k = sortedChars.indexOf(chars[i]);
      cnt[i] = k;
    }
    long fn = 1;
    System.out.println(Arrays.toString(cnt));
    for (int i = chars.length - 1; i >= 0; i--) {
      fn = (fn * i) % MOD;
      ans += cnt[i] * fn;
      sortedChars.remove(chars[i]);
      System.out.println(sortedChars + " " + cnt[i] + " " + fn + " " + ans);
    }
    System.out.println(ans);
    return (int) ans;
  }

  public long factorial(long A, long m) {
    if (A == 0) return 0;
    long res = 1;
    for (int i = 1; i <= A; i++) res = (res * i) % m;
    return res;
  }
}
