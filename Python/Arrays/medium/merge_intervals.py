"""
Problem Link:
https://leetcode.com/problems/merge-intervals/

Approaches:

1. Greedy with Sorting (Optimal)
   Sort the intervals based on their starting points. Traverse the sorted
   intervals while maintaining the previously merged interval.
   - If the current interval overlaps with the previous one, merge them by
     updating the ending point to the maximum of both intervals.
   - Otherwise, add the previous interval to the result and start a new
     merged interval.
   - Time: O(n log n)
   - Space: O(n)
"""

def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []

        if len(intervals) <= 1:
            return intervals
        
        intervals.sort(key=lambda x : x[0])

        prev = intervals[0]

        for i in range(1, len(intervals)):
            if intervals[i][0] <= prev[1]: # overlap
                prev[1] = max(intervals[i][1], prev[1]) # merge by choosing greater element
            else:
                res.append(prev)
                prev = intervals[i]
        
        res.append(prev)
        return res
