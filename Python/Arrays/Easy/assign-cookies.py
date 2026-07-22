"""
Problem Link:
https://leetcode.com/problems/assign-cookies/

Approaches:

1. Brute Force
   For each child, search for the smallest unused cookie that can satisfy
   the child's greed factor. Mark the cookie as used once assigned.
   - Time: O(n × m)
   - Space: O(m)

2. Greedy with Sorting (Optimal)
   Sort both the children's greed factors and the cookie sizes.
   Use two pointers:
   - One for cookies.
   - One for children.
   Assign the smallest cookie that can satisfy the current child.
   This greedy strategy maximizes the number of satisfied children.
   - Time: O(n log n + m log m)
   - Space: O(1) (Ignoring sorting space)
"""

from typing import List

# =====================================================
# Approach 1: Brute Force
# =====================================================

def find_content_children_brute(g: List[int], s: List[int]) -> int:
    used = [False] * len(s)
    count = 0

    for greed in g:
        idx = -1

        for i in range(len(s)):
            if not used[i] and s[i] >= greed:
                if idx == -1 or s[i] < s[idx]:
                    idx = i

        if idx != -1:
            used[idx] = True
            count += 1

    return count


# =====================================================
# Approach 2: Greedy with Sorting (Optimal)
# =====================================================

def find_content_children(g: List[int], s: List[int]) -> int:
    n = len(g)
    m = len(s)

    g.sort()
    s.sort()

    l, r = 0, 0

    while l < m and r < n:
        if g[r] <= s[l]:
            r += 1
        l += 1

    return r