/*
Problem: Rotate Array
Link: https://leetcode.com/problems/rotate-array/

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Compute k = k % n to handle cases where k is greater than the array length.
2. Reverse the entire array.
3. Reverse the first k elements.
4. Reverse the remaining n - k elements.
5. The array is now rotated to the right by k steps.
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

