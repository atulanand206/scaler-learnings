package com.atul.scaler.lean.strings.windowstring;

import static com.atul.scaler.lean.utils.O.attach;
import static com.atul.scaler.lean.utils.O.debug;
import static com.atul.scaler.lean.utils.S.string;

/** @author atulanand */
public class Solution {

  private static final long MOD = (long) 1E9 + 7;

  public String minWindow(String A, String B) {
    long[] pows = powers();
    int[] freq = frequency(B.toCharArray());
    boolean[] fin = presence(freq);
    int total = present(freq);
    long BHash = hashed(freq, pows);
    debug(string(total));
    debug(string(BHash));
    long AHash = 0;
    char[] chs = A.toCharArray();
    boolean found = false;
    int left = 0, right = 0;
    int ls = 0, rs = chs.length;
    int i = 0;
    while (right < chs.length) {
      while (right < chs.length && total >= 0) {
        debug(string(right));
        //        System.out.println(total);
        int ch = of(chs[right]);
        if (fin[ch]) {
          freq[ch]--;
          System.out.println(freq[ch] + " " + total);
          if (freq[ch] == 0 || freq[ch] == -1) total--;
          AHash = hashChange(pows, AHash, chs[right], 1);
          if (AHash == BHash) {
            found = true;
            if (right - left < rs - ls) {
              ls = left;
              rs = right + 1;
            }
          }
        }
        //        debug(string(AHash));
        //        debug(string(total));
        debug(string(A.substring(left, right + 1)));
        if (right + 1 < chs.length) right++;
      }

      right--;

      while (left <= right && chs[left] != chs[right] && total <= 0) {
        debug(string(left));
        int ch = of(chs[left]);
        if (fin[ch]) {
          freq[ch]++;
          if (freq[ch] == 0 || freq[ch] == 1) total++;
          AHash = hashChange(pows, AHash, chs[left], -1);
          if (AHash == BHash) {
            found = true;
            if (right - left < rs - ls) {
              ls = left;
              rs = right + 1;
            }
          }
        }
        //        debug(string(AHash));
        debug(string(A.substring(left, right + 1)));
        left++;
      }
      if (left < chs.length) {
        int ch = of(chs[left]);
        freq[ch]++;
        if (freq[ch] == 0 || freq[ch] == 1) total++;
        AHash = hashChange(pows, AHash, chs[left], -1);
        if (AHash == BHash) {
          found = true;
          if (right - left < rs - ls) {
            ls = left;
            rs = right + 1;
          }
        }
        left++;
      }
    }
    debug(string(found));
    return found ? A.substring(ls, rs) : "";
  }

  private boolean[] presence(int[] freq) {
    boolean[] res = new boolean[freq.length];
    for (int j = 0; j < freq.length; j++) if (freq[j] != 0) res[j] = true;
    return res;
  }

  private int present(int[] freq) {
    int cnt = 0;
    for (int i : freq) if (i != 0) cnt++;
    return cnt;
  }

  private int[] frequency(char[] ch) {
    int[] freq = new int[52];
    for (char c : ch) freq[of(c)]++;
    return freq;
  }

  private long hashChange(long[] powers, long hash, char ch, int count) {
    return (hash + ((powers[of(ch)] * count) % MOD + MOD) % MOD) % MOD;
  }

  private long hashed(int[] freq, long[] powers) {
    long hash = 0;
    for (int i = 0; i < freq.length; i++) hash = (hash + ((long) freq[i] * powers[i]) % MOD) % MOD;
    return hash;
  }

  private long[] powers() {
    long[] res = new long[52];
    res[0] = 1;
    for (int i = 1; i < 52; i++) res[i] = (res[i - 1] * 52) % MOD;
    return res;
  }

  private int of(char c) {
    if ((int) c >= 97) return (int) c - 97;
    return (int) c - 65 + 26;
  }

  public static void main(String[] args) {
    attach();
    Solution s = new Solution();
    System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
  }
}
