package com.atul.scaler.lean.arrays.equilibriumindex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * Problem: You are given an array A of integers of size N. Your task is to find the equilibrium
 * index of the given array
 *
 * <p>Equilibrium index of an array is an index such that the sum of elements at lower indexes is
 * equal to the sum of elements at higher indexes.
 *
 * <p>NOTE:
 *
 * <p>Array indexing starts from 0.
 *
 * <p>If there is no equilibrium index then return -1.
 *
 * <p>If there are more than one equilibrium indexes then return the minimum index.
 *
 * <p>Problem Constraints:
 *
 * <p>1<=N<=1e5
 *
 * <p>-1e5<=A[i]<=1e5
 *
 * <p>Input: First argument contains an array A .
 *
 * <p>Return: Return the equilibrium index of the given array. If no such index is found then return
 * -1.
 *
 * <p>Approach: We have to find the equilibrium index of the given array.
 *
 * <p>1. For each element, we have to check if the sum of elements on the left side is equal to the
 * sum of elements on the right side.
 *
 * <p>2. The chosen element won't be present in the sum.
 *
 * <p>3. For range sum problems, we calculate the prefix sum array for determining sum of elements
 * from 0 to i.
 *
 * <p>4. As the sum of elements on both sides is same, we can say the following:
 *
 * <p>4.1. 2 * sum of elements on left + current element = sum of all elements.
 *
 * <p>5. Additionally, there are some trivial cases when all elements are 0. The first element can
 * be considered as the divider as the sum of elements on both sides is equal to 0.
 *
 * <p>6. This will take O(N) time complexity & O(N) space complexity.
 *
 * @author atulanand
 */
public class Solution {

  public int solve(ArrayList<Integer> A) {
    int sum = A.stream().reduce(0, Integer::sum);
    if (sum == 0 && A.size() % 2 != 0 && new HashSet<>(A).size() == 1) return 0;
    ArrayList<Integer> pref =
        A.stream()
            .collect(
                Collector.of(
                    ArrayList::new,
                    (a, b) -> a.add(a.isEmpty() ? b : (b + a.get(a.size() - 1))),
                    (a, b) -> {
                      throw new UnsupportedOperationException();
                    }));
    System.out.println(pref + " " + sum + " \n");
    return IntStream.range(1, A.size() - 1)
        .boxed()
        .filter(i -> (A.get(i) + 2 * pref.get(i - 1) == sum))
        .findFirst()
        .orElse(-1);
  }
}
