package com.atul.scaler.lean.primer.vowelit;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Problem: Given a string A of lowercase English alphabets, find and return a string which is the
 * longest subsequence of vowels in the string A.
 *
 * <p>Constraints: 1 <= length of the string <= 100000
 *
 * <p>Input: The only argument given is string A.
 *
 * <p>Output: Return a string which is the longest subsequence of vowels in the string A.
 *
 * <p>Approach:
 *
 * <p>1. Convert the string into a stream, filter out the vowels and join the stream into a string.
 *
 * @author Atul Anand
 */
public class Solution {
  public String solve(String A) {
    return Arrays.stream(A.split(""))
        .filter(x -> "aeiou".contains(x))
        .collect(Collectors.joining());
  }
}
