package com.atul.scaler.lean.linkedlist.removenthfromend;

import static com.atul.scaler.lean.utils.O.attach;
import static com.atul.scaler.lean.utils.O.debug;
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
  }

  public ListNode removeNthFromEnd(ListNode A, int B) {
    int count = level(A);
    debug(string(count));
    debug(string(B));
    if (count == 1) if (B == 1) return null;
    if (B > count) return A.next;
    return removeNth(A, count - B);
  }

  private ListNode removeNth(ListNode A, int i) {
    if (A == null) return null;
    if (i == 1) A.next = A.next.next;
    A.next = removeNth(A.next, i - 1);
    return A;
  }

  private int level(ListNode A) {
    if (A == null) return 0;
    return 1 + level(A.next);
  }

  private static void print(ListNode p) {
    if (p == null) return;
    StringBuilder sb = new StringBuilder();
    sb.append(p.val);
    while (p.next != null) {
      p = p.next;
      sb.append(" ").append(p.val);
    }
    debug(string(sb));
  }

  public static void main(String[] args) {
    attach();
    ListNode l = new ListNode(1);
    int[] arr = new int[] {2, 3, 4, 5};
    ListNode p = l;
    for (int i : arr) {
      p.next = new ListNode(i);
      p = p.next;
    }
    print(new Solution().removeNthFromEnd(l, 5));
  }
}
