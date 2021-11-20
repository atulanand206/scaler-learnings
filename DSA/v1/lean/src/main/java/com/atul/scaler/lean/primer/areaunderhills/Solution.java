package com.atul.scaler.lean.primer.areaunderhills;

import java.util.Arrays;

public class Solution {

  public String solve(int[] A) {
    return String.valueOf((long) Arrays.stream(A).mapToDouble(Double::valueOf).sum());
  }
}
