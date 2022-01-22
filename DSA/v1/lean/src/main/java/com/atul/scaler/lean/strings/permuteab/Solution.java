package com.atul.scaler.lean.strings.permuteab;

import static com.atul.scaler.lean.utils.O.attach;

/** @author atulanand */
public class Solution {

  public int solve(String A, String B) {
    if (A.length() > B.length()) return 0;
    int[] fA = frequency(A.toCharArray(), 0, A.length());
    int need = A.length();
    int cnt = 0;
    char[] bC = B.toCharArray();
    int[] fB = frequency(bC, 0, A.length());
    for (int j = 0; j < A.length(); j++) {
      int v = (int) bC[j] - 97;
      if (fA[v] != 0) {
        need--;
        fA[v]--;
      }
    }
    if (need == 0) cnt++;
    for (int j = A.length(); j < B.length(); j++) {
      int v = (int) bC[j] - 97;
      int vs = (int) bC[j - A.length()] - 97;
      fA[v]--;
      fA[vs]++;
      if (fA[vs] > 0) need++;
      if (fA[v] >= 0) need--;
      if (need == 0) cnt++;
    }
    return cnt;
  }

  private int[] frequency(char[] A, int s, int e) {
    int[] freq = new int[26];
    for (int i = s; i < e; i++) freq[(int) A[i] - 97]++;
    return freq;
  }

  public static void main(String[] args) {
    attach();
    System.out.println(new Solution().solve("p", "pccdpeeooadeocdoacddapacaecb"));
    System.out.println(new Solution().solve("docp", "aoapeooeoapcpaocecddoocdcqqapeapccc"));
  }
}
