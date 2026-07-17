"""
Problem Link:
https://leetcode.com/problems/rearrange-array-elements-by-sign/

Approaches:

1. Separate Positive and Negative Arrays
   Store all positive and negative numbers in two separate arrays.
   Merge them alternately into the result array.
   - Time: O(n)
   - Space: O(n)

2. Two Pointers with Result Array (Optimal)
   Since the number of positive and negative elements is equal,
   maintain two pointers:
   - Even indices for positive numbers.
   - Odd indices for negative numbers.
   Traverse the array once and place each element directly into
   its correct position.
   - Time: O(n)
   - Space: O(n)
"""

# =====================================================
# Approach 1: Separate Positive and Negative Arrays
# =====================================================

def rearrange_array(nums: List[int]) -> List[int]:
    positive = []
    negative = []

    for num in nums:
        if num > 0:
            positive.append(num)
        else:
            negative.append(num)

    result = [0] * len(nums)

    pos = neg = 0
    idx = 0

    while idx < len(nums):
        result[idx] = positive[pos]
        result[idx + 1] = negative[neg]

        pos += 1
        neg += 1
        idx += 2

    return result


# =====================================================
# Approach 2: Two Pointers with Result Array (Optimal)
# =====================================================

class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:

        n = len(nums)

        # Result array
        result = [0] * n

        # Even indices for positive numbers
        pos = 0

        # Odd indices for negative numbers
        neg = 1

        # Place each element at its correct position
        for num in nums:

            if num > 0:
                result[pos] = num
                pos += 2

            else:
                result[neg] = num
                neg += 2

        return result