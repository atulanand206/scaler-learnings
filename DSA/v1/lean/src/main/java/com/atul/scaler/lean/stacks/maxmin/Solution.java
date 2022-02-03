package com.atul.scaler.lean.stacks.maxmin;

import static com.atul.scaler.lean.utils.O.attach;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;
import java.time.Duration;
import java.time.Instant;
import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

/** @author atulanand */
public class Solution {

  private static final int MOD = (int) 1E9 + 7;

  public int solve(int[] A) {
    O.debug(S.string(A.length));
    int[] nearestSmallerOnLeft = iteration(A, true, true);
    int[] nearestGreaterOnLeft = iteration(A, false, true);
    int[] nearestSmallerOnRight = iteration(A, true, false);
    int[] nearestGreaterOnRight = iteration(A, false, false);

    O.debug(S.string(A));
    O.debug(S.string(nearestSmallerOnLeft));
    O.debug(S.string(nearestSmallerOnRight));
    O.debug(S.string(nearestGreaterOnLeft));
    O.debug(S.string(nearestGreaterOnRight));

    long res = 0;
    for (int i = 0; i < A.length; i++) {
      long max = subArraysWithCurrent(nearestGreaterOnLeft[i], i, nearestGreaterOnRight[i]);
      long min = subArraysWithCurrent(nearestSmallerOnLeft[i], i, nearestSmallerOnRight[i]);
      long contribution = ((max - min) * A[i]) % MOD;
      res = (res + contribution) % MOD;
      res = (res + MOD) % MOD;
    }
    return (int) res;
  }

  private long subArraysWithCurrent(long leftEx, long current, long rightEx) {
    return (current - leftEx) * (rightEx - current);
  }

  private static class For {
    int start;
    IntPredicate end;
    IntUnaryOperator next;

    public static For of(int left, int right, int increment) {
      For f = new For();
      f.start = increment > 0 ? left : right;
      f.end = increment > 0 ? x -> x <= right : x -> x >= left;
      f.next = x -> x + increment;
      return f;
    }
  }

  private int[] iteration(int[] A, boolean smaller, boolean increasing) {
    return iterate(
        A,
        For.of(0, A.length - 1, increasing ? 1 : -1),
        (curr, next) -> smaller ? curr >= next : curr <= next,
        increasing ? -1 : A.length);
  }

  private int[] iterate(int[] A, For loop, BiPredicate<Integer, Integer> pop, int fallback) {
    int[] res = new int[A.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = loop.start; loop.end.test(i); i = loop.next.applyAsInt(i)) {
      while (!stack.isEmpty() && pop.test(A[stack.peek()], A[i])) {
        stack.pop();
      }
      res[i] = !stack.isEmpty() ? stack.peek() : fallback;
      stack.push(i);
    }
    return res;
  }

  public static void main(String[] args) {
    attach();
    Instant start = Instant.now();
    System.out.println(new Solution().solve(new int[] {4, 7, 3, 8}));
    Duration duration = Duration.between(Instant.now(), start);
    System.out.println(duration);
  }
}
