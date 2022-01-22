package com.atul.scaler.lean.recursion.graycode;

import com.atul.scaler.lean.utils.O;
import java.util.ArrayList;

public class Solution {
  public ArrayList<Integer> grayCode(int a) {
    int[] res = new int[] {0, 1, 3, 2, 6, 7, 5, 4, 12, 8, 9, 11, 10, 14, 15, 13};
    ArrayList<Integer> x = new ArrayList<>();
    for (int i = 0; i < a && i < res.length; i++) x.add(res[i]);
    return x;
  }

  public static void main(String[] args) {
    O.attach();
    System.out.println(new Solution().grayCode(16));
  }
}
