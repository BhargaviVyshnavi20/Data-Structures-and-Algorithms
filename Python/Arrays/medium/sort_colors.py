"""
Problem Link:
https://leetcode.com/problems/sort-colors/

Approaches:

1. Built-in Sorting
   Sort the array using the built-in sorting function.
   The elements are automatically arranged in the required order.
   - Time: O(n log n)
   - Space: O(1)

2. Counting Frequency
   Count the occurrences of 0s, 1s, and 2s in a single traversal.
   Reconstruct the array based on their frequencies.
   - Time: O(n)
   - Space: O(n)

3. Single Pass with Extra Array
   Traverse the array once while placing 0s from the left and 2s from the right.
   Initialize the remaining positions with 1s to obtain the sorted array.
   - Time: O(n)
   - Space: O(n)

4. Dutch National Flag Algorithm (Optimal)
   Use three pointers to partition the array into 0s, 1s, and 2s in-place.
   Swap elements into their correct regions while traversing the array only once.
   - Time: O(n)
   - Space: O(1)
"""

# =====================================================
# Approach 1: Built-in Sorting
# =====================================================

def sort_colors(nums: List[int]) -> None:
    nums.sort()


# =====================================================
# Approach 2: Counting Frequency
# =====================================================

def sort_colors(nums: List[int]) -> None:
    zeros = ones = twos = 0

    for num in nums:
        if num == 0:
            zeros += 1
        elif num == 1:
            ones += 1
        else:
            twos += 1

    nums[:] = [0] * zeros + [1] * ones + [2] * twos


# =====================================================
# Approach 3: Single Pass with Extra Array
# =====================================================

def sort_colors(nums: List[int]) -> None:
    left = 0
    right = len(nums) - 1
    result = [1] * len(nums)

    for num in nums:
        if num == 0:
            result[left] = 0
            left += 1
        elif num == 2:
            result[right] = 2
            right -= 1

    nums[:] = result


# =====================================================
# Approach 4: Dutch National Flag Algorithm (Optimal)
# =====================================================

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        left = mid = 0
        right = len(nums) - 1

        while mid <= right:
            if nums[mid] == 0:
                nums[left], nums[mid] = nums[mid], nums[left]
                left += 1
                mid += 1

            elif nums[mid] == 1:
                mid += 1

            else:
                nums[mid], nums[right] = nums[right], nums[mid]
                right -= 1