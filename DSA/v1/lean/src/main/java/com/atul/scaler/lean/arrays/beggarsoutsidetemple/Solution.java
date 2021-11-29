package com.atul.scaler.lean.arrays.beggarsoutsidetemple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has
 * an empty pot. When the devotees come to the temple, they donate some amount of coins to these
 * beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K
 * beggars sitting next to each other.
 *
 * <p>Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <=
 * i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day,
 * provided they don't fill their pots by any other means.
 *
 * <p>Assuming, there are B devotees who donated.
 *
 * <p>Example
 *
 * <p>Input: N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 *
 * <p>Return: [10, 55, 45, 25, 25]
 *
 * <p>Approach: We have to find the amount of money with each beggar.
 *
 * <p>1. Intuitively, if a value has to be added as contribution from any index, add it there and
 * subtract it from where the contribution has to be stopped.
 *
 * <p>2. Take a prefix sum of the contribution array and find the amounts each beggar will have in
 * the end.
 *
 * <p>3. This will take O(N + B) time complexity & O(N) space complexity.
 *
 * @author atulanand
 */
public class Solution {

  public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
    List<Integer> donations =
        IntStream.range(0, A).map(i -> 0).boxed().collect(Collectors.toList());
    B.forEach(
        donation -> {
          int startIdx = donation.get(0) - 1;
          int endNextIdx = donation.get(1);
          int amount = donation.get(2);
          donations.set(startIdx, donations.get(startIdx) + amount);
          if (endNextIdx < donations.size())
            donations.set(endNextIdx, donations.get(endNextIdx) - amount);
        });
    ArrayList<Integer> result =
        donations.stream()
            .collect(
                Collector.of(
                    ArrayList::new,
                    (a, b) -> a.add(a.isEmpty() ? b : (b + a.get(a.size() - 1))),
                    (a, b) -> {
                      throw new UnsupportedOperationException();
                    }));
    return result;
  }
}
