package com.atul.scaler.lean.strings.boringsubstring;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

import static com.atul.scaler.lean.utils.O.debug;
import static com.atul.scaler.lean.utils.S.string;

/** @author atulanand */
public class Solution {

  public int solve(String A) {
    int minOdd = 150;
    int minEven = 150;
    int maxOdd = 0;
    int maxEven = 0;
    for (char ch : A.toCharArray()) {
      if (((int) ch) % 2 == 0) {
        minEven = Math.min(minEven, ch);
        maxEven = Math.max(maxEven, ch);
      } else {
        minOdd = Math.min(minOdd, ch);
        maxOdd = Math.max(maxOdd, ch);
      }
    }
    debug(string(minOdd));
    debug(string(maxOdd));
    debug(string(minEven));
    debug(string(maxEven));
    debug(string(Math.abs(minOdd - minEven)));
    debug(string(Math.abs(minOdd - maxEven)));
    debug(string(Math.abs(minEven - minOdd)));
    debug(string(Math.abs(minEven - maxOdd)));
    if (maxOdd == 0 || maxEven == 0) return 1;
    if (Math.abs(minOdd - minEven) > 1) return 1;
    if (Math.abs(minOdd - maxEven) > 1) return 1;
    if (Math.abs(maxOdd - minEven) > 1) return 1;
    if (Math.abs(maxOdd - maxEven) > 1) return 1;
    return 0;
  }

  public static void main(String[] args) {
    O.attach();
    debug(string(new Solution().solve("hfffgggfhhhgg")));
  }
}
