// Problem Link: https://leetcode.com/problems/two-sum/

import java.util.HashMap;

/*
Problem:
Given an array of integers `nums` and an integer `target`,
return the indices of the two numbers such that they add up
to the target.

You may assume that each input has exactly one solution,
and you may not use the same element twice.

Example:
Input:
nums = [2, 7, 11, 15]
target = 9

Output:
[0, 1]

Explanation:
nums[0] + nums[1] = 2 + 7 = 9,
so return their indices.
*/

public class TwoSum {

    // ==========================================================
    // Approach 1: Brute Force
    // ==========================================================
    // Time Complexity : O(N²)
    // Space Complexity: O(1)
    //
    // Check every possible pair of elements.
    // If the sum of the current pair equals the target,
    // return their indices immediately.
    // ==========================================================

    public static int[] twoSumBruteForce(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }


    // ==========================================================
    // Approach 2: Hash Map (One Pass)
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(N)
    //
    // Traverse the array once while storing each number
    // and its index in a hash map.
    //
    // For every element, compute its complement
    // (target - current element).
    // If the complement already exists in the map,
    // return the stored index and the current index.
    // Otherwise, store the current element and its index
    // for future lookups.
    // ==========================================================

    public static int[] twoSumHashMap(int[] nums, int target) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (hashmap.containsKey(complement)) {
                return new int[]{hashmap.get(complement), i};
            }

            hashmap.put(nums[i], i);
        }

        return new int[]{};
    }
}