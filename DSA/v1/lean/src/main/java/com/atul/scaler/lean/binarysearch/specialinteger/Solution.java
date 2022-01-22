package com.atul.scaler.lean.binarysearch.specialinteger;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

public class Solution {

  public int solve(int[] A, int B) {
    int s = 0, e = A.length;
    int mid;
    int ans = 0;
    while (s <= e) {
      mid = (s + e) / 2;
      O.debug(S.string(mid));
      if (maxSubArraySum(A, mid) > B) {
        e = mid - 1;
      } else {
        ans = Math.max(ans, mid);
        s = mid + 1;
      }
    }
    return ans;
  }

  private long maxSubArraySum(int[] A, int k) {
    long sum = 0;
    int i = 0;
    while (i < A.length && i < k) sum += A[i++];
    long ans = sum;
    while (i < A.length) {
      sum += A[i];
      sum -= A[i - k];
      ans = Math.max(ans, sum);
      i++;
    }
    return ans;
  }
}
