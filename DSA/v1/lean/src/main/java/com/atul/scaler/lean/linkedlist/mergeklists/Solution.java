package com.atul.scaler.lean.linkedlist.mergeklists;

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

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode result = null;
    ListNode ptr = result;
    while (true) {
      ListNode min = null;
      for (ListNode x : lists) {
        if (x != null) {
          if (min == null) min = x;
          else {
            if (min.val > x.val) min = x;
          }
          x = x.next;
        }
      }
      if (min == null) break;
      if (result == null) result = min;
      else {
        result.next = min;
        result = result.next;
      }
    }
    return ptr;
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
    //    print(new Solution().mergeKLists(l, 5));
  }
}
