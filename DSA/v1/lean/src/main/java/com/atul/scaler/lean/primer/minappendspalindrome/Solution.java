package com.atul.scaler.lean.primer.minappendspalindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given a string A consisting of lowercase characters.
 *
 * <p>We need to tell minimum characters to be appended (insertion at end) to make the string A a
 * palindrome.
 *
 * <p>Constraints:
 *
 * <p>1 <= |A| <= 105
 *
 * <p>A consists only of lower-case characters.
 *
 * <p>Input: First argument is an string A.
 *
 * <p>Output: Return a integer denoting the minimum characters to be appended (insertion at end) to
 * make the string A a palindrome.
 *
 * <p>Approach:
 *
 * <p>1. We need to find the characters to be appended to make the string a palindrome.
 *
 * <p>2. Any palindrome has the property it reads the same backward as forward.
 *
 * <p>3. If we reverse the string, we can compare it with the original string.
 *
 * <p>4. If the suffix of original string is equal to the prefix of reversed string of the same
 * length, then we can append the rest of the reversed string into the original string and we'll
 * have a palindrome string.
 *
 * <p>4.1. We can use 2 for loops to iterate through the original string and reversed string and
 * find the matching substrings.
 *
 * <p>4.2. We can determine the prefix and suffix string arrays and only compare the strings of
 * equal length to find the matching substrings.
 *
 * <p>5. The no of characters required to be appended is the length of the part of the reverse
 * string required to make it a palindrome.
 *
 * @author Atul Anand
 */
public class Solution {

  public int solve(String A) {
    char[] chars = A.toCharArray();
    char[] reverse = new char[chars.length];
    int k = 0;
    for (int j = chars.length - 1; j >= 0; j--) {
      reverse[k++] = chars[j];
    }
    return prefixSuffix(chars, reverse);
  }

  private int naive(char[] chars, char[] reverse) {
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars.length - i; j++) {
        if (chars[j + i] != reverse[j]) {
          break;
        }
        if (j + i == chars.length - 1) {
          return i;
        }
      }
    }
    return chars.length;
  }

  private int prefixSuffix(char[] chars, char[] reverse) {
    List<String> prefix = new ArrayList<>();
    List<String> suffix = new ArrayList<>();
    for (int i = 0; i < chars.length; i++) {
      suffix.add(String.valueOf(chars, chars.length - i - 1, i + 1));
      prefix.add(String.valueOf(reverse, 0, i + 1));
    }
    prefix.sort((x, y) -> Integer.compare(x.length(), y.length()));
    suffix.sort((x, y) -> Integer.compare(x.length(), y.length()));
    for (int i = prefix.size() - 1; i >= 0; i--) {
      String p = prefix.get(i);
      String s = suffix.get(i);
      if (p.equals(s)) {
        return chars.length - p.length();
      }
    }
    return 0;
  }
}
