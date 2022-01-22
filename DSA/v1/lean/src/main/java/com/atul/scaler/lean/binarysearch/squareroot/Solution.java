package com.atul.scaler.lean.binarysearch.squareroot;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

public class Solution {

  public int sqrt(int A) {
    long s = 1, e = A;
    long ans = 0;
    while (s <= e) {
      long mid = (s + e) / 2;
      long sq = mid * mid;
      O.debug(S.string(mid + " " + sq));
      if (sq <= A) {
        ans = Math.max(ans, mid);
        s = mid + 1;
      } else e = mid - 1;
    }
    return (int) ans;
  }
}
