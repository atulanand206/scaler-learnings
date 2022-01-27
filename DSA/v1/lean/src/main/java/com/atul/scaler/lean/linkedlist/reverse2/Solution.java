package com.atul.scaler.lean.linkedlist.reverse2;

import static com.atul.scaler.lean.utils.O.*;
import static com.atul.scaler.lean.utils.S.string;

/** @author atulanand */
public class Solution {

  static class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }

    @Override
    public String toString() {
      return "ListNode{" +
              "val=" + val +
              '}';
    }
  }

  private ListNode reverseBetween(ListNode A, int B, int C) {
    ListNode ptr = A;
    int k = B;
    C -= B;
    while (B > 2) {
      ptr = ptr.next;
      B--;
    }
    ListNode prev = null, curr = ptr.next, next = null;
    boolean first = k == 1;
    boolean last = false;
    if (first) curr = ptr;
    ListNode head = ptr;
    ListNode tail = curr;
    print("head",  head);
    print("curr",  curr);
    print("A",  A);
    int c = 0;
    while (C >= 0) {
      if (C == 0 && curr.next == null) last = true;
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      C--;
    }
    if (first && last) return prev;
    if (prev != null) print("prev", prev);
    if (next != null) print("next", next);
    debug(string(last));
    ListNode x = head.next;
    print("A", A);
    print("head",  head);
    if (x != null) print("X", x);
    if (first) A = prev;
    else head.next = prev;
    tail.next = next;
    print("A", A);
    debugN();
    return A;
  }

  private static void print(String s, ListNode p) {
    //    if (p == null) return;
    StringBuilder sb = new StringBuilder(s);
    while (p.next != null) {
      sb.append(" ").append(p.val).append(" ");
      p = p.next;
    }
    sb.append(" ").append(p.val).append(" ");
    debug(string(sb));
  }

  public static void main(String[] args) {
    attach();
    extracted(1, new int[] {2, 3}, 1, 2);
    extracted(1, new int[] {2, 3}, 2, 3);

    extracted(1, new int[] {2, 3, 4, 5, 6, 7, 8, 9}, 2, 5);
    extracted(
        97,
        new int[] {63, 89, 34, 82, 95, 4, 70, 14, 41, 38, 83, 49, 32, 68, 56, 99, 52, 33, 54},
        13,
        15);
    extracted(83, new int[] {13 , 21 , 72 }, 1, 4);
  }

  private static void extracted(int start, int[] arr, int B, int C) {
    ListNode l = new ListNode(start);
    ListNode p = l;
    for (int i : arr) {
      p.next = new ListNode(i);
      p = p.next;
    }
    new Solution().reverseBetween(l, B, C);
  }
}
