package com.atul.scaler.lean.arrays.mergeintervals;

import java.util.ArrayList;

/**
 * Problem: Given a set of non-overlapping intervals, insert a new interval into the intervals
 * (merge if necessary). You may assume that the intervals were initially sorted according to their
 * start times.
 *
 * <p>Problem Constraints: 0 <= |intervals| <= 10^5
 *
 * <p>Input: First argument is the vector of intervals. second argument is the new interval to be
 * merged.
 *
 * <p>Output: Return the vector of intervals after merging.
 *
 * <p>Approach: We have to insert a new interval into a list of intervals resulting in
 * non-overlapping intervals.
 *
 * <p>1. As all intervals are non-overlapping in the beginning, no two intervals will be present at
 * one point on the number line.
 *
 * <p>2. If we iterate interval wise, we can consider one interval from the list and determine
 * whether to keep it as is or merge with the new interval.
 *
 * <p>3. Extending, all the intervals present strictly before and after the new interval will be
 * taken as is.
 *
 * <p>4. But, for the intervals overlapping with the new interval, we can figure out the smallest
 * and largest value present among all those intervals.
 *
 * <p>5. Simply iterating from the left side will give the updated intervals list.
 *
 * <p>This will take O(n) time complexity & O(n) space complexity.
 *
 * @author atulanand
 */
public class Solution {

  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }
    result.add(newInterval);
    while (i < intervals.size()) {
      result.add(intervals.get(i));
      i++;
    }
    return result;
  }
}

class Interval {
  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }

  public String toString() {
    return "[" + start + "," + end + "]";
  }
}
