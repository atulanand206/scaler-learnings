package com.atul.scaler.lean.primer.ponnymobilephones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Little pony is going to buy some mobile phones for his friends. As there many models
 * available in the market at different prices, He is confused and wants to know the maximum
 * distinct models of a mobile phone he can buy for his friends, given that he has a total X amount
 * of money.
 *
 * <p>You are given an array A of size N. denoting the size of prices of different models. The array
 * is sorted based on prices in increasing order. You are given another array B of size Q denoting
 * the queries. In i'th query, you need to tell the maximum distinct models of mobile phones he can
 * buy with B[i] money.
 *
 * <p>Constraints:
 *
 * <p>1 <= N, Q <= 105
 *
 * <p>1 <= A[i] <= 104
 *
 * <p>1 <= B[i] <= 109
 *
 * <p>Input: The 1st argument of the input is the array A. The 2nd argument of the input is the
 * array B containing the description of the queries.
 *
 * <p>Output: Your function should return the answer to all queries in an array (in the same order
 * they were asked in the input).
 *
 * <p>Approach:
 *
 * <p>1. We want to know the maximum distinct models of a mobile phone which can be bought with an
 * amount.
 *
 * <p>2. The input array is sorted in increasing order.
 *
 * <p>3. We can infer that to buy more models, the ones with lowest price will have to be bought and
 * the expensive models won't affect anything in those cases.
 *
 * <p>4. We can make a prefix sum array of the array A.
 *
 * <p>5. Now we have to find for each query, which index is having a maximum value less than or
 * equal to each query value.
 *
 * <p>6. There are two approaches to solve this problem.
 *
 * <p>6.1. We can use a hash map in which key will be the amount and value will be the maximum
 * number of phones at that amount. Simply returning the value at that key will give the answer.
 *
 * <p>6.1.1. This is giving runtime error due to heap space limit.
 *
 * <p>6.2. We can use binary search to find the lower bound of the query in the prefix sum array.
 *
 * <p>6.2.1. This is giving time limit exceeded error due to repeated binary searches.
 *
 * <p>7. Both the approaches are giving correct output for smaller values.
 *
 * @author Atul Anand
 */
public class Solution {
  public int[] solve(int[] A, int[] B) {
    // return binarySearch(A, B);
    return hashMap(A, B);
  }

  private int[] hashMap(int[] A, int[] B) {
    List<Integer> list = listOfSums(A);

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < list.get(0); i++) map.put(i, 0);
    for (int i = 0; i < list.size() - 1; i++)
      for (int j = list.get(i); j < list.get(i + 1); j++) map.put(j, i + 1);
    map.put(map.size(), list.size());

    int[] result = new int[B.length];
    for (int i = 0; i < B.length; i++)
      result[i] = (B[i] > map.size()) ? list.size() : map.get(B[i]);
    return result;
  }

  private int[] binarySearch(int[] A, int[] B) {
    List<Integer> list = listOfSums(A);

    int[] result = new int[B.length];
    for (int i = 0; i < B.length; i++) result[i] = lowerBound(list, B[i]);
    return result;
  }

  private List<Integer> listOfSums(int[] A) {
    List<Integer> list = new ArrayList<>();
    list.add(A[0]);
    for (int i = 1; i < A.length; i++) {
      if (list.get(list.size() - 1) + A[i] > Integer.MAX_VALUE) break;
      list.add(list.get(list.size() - 1) + A[i]);
    }
    return list;
  }

  private int lowerBound(List<Integer> list, int value) {
    int low = 0;
    int high = list.size() - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (list.get(mid) < value) low = mid + 1;
      else high = mid - 1;
    }
    return low;
  }
}
