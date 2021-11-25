package com.atul.scaler.lean.arrays.addone;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem: Given a non-negative number represented as an array of digits, add 1 to the number
 * (increment the number represented by the digits).
 *
 * <p>The digits are stored such that the most significant digit is at the head of the list.
 *
 * <p>NOTE: Certain things are intentionally left unclear in this question which you should practice
 * asking the interviewer. For example: for this problem, following are some good questions to ask :
 *
 * <p>Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a
 * valid input? A : For the purpose of this question, YES
 *
 * <p>Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a
 * valid output? A : For the purpose of this question, NO. Even if the input has zeroes before the
 * most significant digit.
 *
 * <p>Problem Constraints: 1 <= size of the array <= 1000000
 *
 * <p>Input: First argument is an array of digits.
 *
 * <p>Output: Return the array of digits after adding one.
 *
 * <p>Approach: This problem is the exact simulation of childhood addition with the carry over.
 *
 * <p>The problem mentions that leading zeros are invalid. If we take them out, it won't matter.
 *
 * <p>In the basic concept, when we have a carry over, we start the computation from the units place
 * and move towards higher places like tens or hundreds. If the value is less than 9, it's simply
 * increment otherwise it's changed to 0 and the carry moves to next place. If there's nothing in
 * the end and we still have a carry, we add a 1 to finish the computation. This will take O(n) time
 * complexity & O(1) space complexity.
 *
 * <p>Simulating this behaviour in code is quite simple with the Collections reverse API.
 *
 * <p>1. We remove the leading zeroes using a while loop which checks if a zero is present at the
 * starting index and throws the element out of the list.
 *
 * <p>2. We reverse the list to begin computation from the units place. Simply checking the
 * conditions and moving to the next index.
 *
 * <p>3. In the while loop, we break out if carry over is finished. In case, it's not finished till
 * the last index, we add a 1 in the list.
 *
 * <p>4. Reverse the list and we have our answer.
 *
 * @author atulanand
 */
public class Solution {

  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    while (A.size() > 1 && A.get(0) == 0) {
      A.remove(0);
    }
    Collections.reverse(A);
    int i = 0;
    while (i < A.size()) {
      if (A.get(i) < 9) {
        A.set(i, A.get(i) + 1);
        break;
      } else {
        A.set(i, 0);
        i++;
      }
    }
    if (i == A.size()) {
      A.add(1);
    }
    Collections.reverse(A);
    return new ArrayList<>(A);
  }
}
