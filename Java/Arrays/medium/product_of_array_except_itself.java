/*
Problem Link:
https://leetcode.com/problems/product-of-array-except-self/

Approach: Prefix & Suffix Products

For each index:
- Store the product of all elements to its left.
- Traverse from right to left while maintaining the product of all
  elements to its right.
- Multiply the left product by the right product.

This avoids division and runs in linear time.

- Time: O(n)
- Space: O(1) (excluding the output array)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}