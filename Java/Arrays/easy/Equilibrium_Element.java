// Problem Link: https://leetcode.com/problems/find-pivot-index/

/*
Problem:
Given an integer array nums, return the pivot index.

The pivot index is the index where the sum of all the numbers
strictly to the left of the index is equal to the sum of all
the numbers strictly to the right of the index.

If no such index exists, return -1.

Example 1:
Input:
nums = [1,7,3,6,5,6]

Output:
3

Explanation:
Left sum = 1 + 7 + 3 = 11
Right sum = 5 + 6 = 11

------------------------------------------------------------

Example 2:
Input:
nums = [1,2,3]

Output:
-1

Explanation:
There is no index where left sum equals right sum.

------------------------------------------------------------

Example 3:
Input:
nums = [2,1,-1]

Output:
0

Explanation:
Left sum = 0
Right sum = 1 + (-1) = 0
*/

public class Equilibrium_Element {

    // ==========================================================
    // Approach: Prefix Sum (Single Traversal)
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    //
    // Observation:
    // Let totalSum be the sum of all elements.
    //
    // While traversing the array, maintain leftSum.
    //
    // For every index i:
    //
    // rightSum = totalSum - leftSum - nums[i]
    //
    // If leftSum == rightSum,
    // then i is the equilibrium (pivot) index.
    //
    // Otherwise, update leftSum by adding nums[i]
    // and continue.
    // ==========================================================

    public static int pivotIndex(int[] nums) {

        // Compute total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Find pivot index
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

    // Driver Code
    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};

        System.out.println("Equilibrium Index = " + pivotIndex(nums));
    }
}