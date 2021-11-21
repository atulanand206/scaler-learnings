package com.atul.scaler.lean.primer.ponnymobilephones;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

  private Stream<Integer> listOfSums(int[] A) {
    int[] prefixSum = A.clone();
    Arrays.parallelPrefix(prefixSum, Integer::sum);
    return Arrays.stream(prefixSum).boxed().sorted();
  }

  private int[] hashMap(int[] A, int[] B) {
    List<Integer> list = listOfSums(A).collect(Collectors.toList());
    return Arrays.stream(B).parallel().map(e -> findCount(list, e)).toArray();
  }

  private int findCount(List<Integer> list, int e) {
    Optional<Integer> val = list.stream().filter(x -> x >= e).findFirst();
    if (!val.isPresent()) return (int) list.size();
    return IntStream.range(0, list.size())
        .filter(userInd -> list.get(userInd).equals(val.get()))
        .findFirst()
        .getAsInt();
  }

  private int[] binarySearch(int[] A, int[] B) {
    List<Integer> list = listOfSums(A).collect(Collectors.toList());
    return Arrays.stream(B).parallel().map(x -> lowerBound(list, x)).toArray();
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
