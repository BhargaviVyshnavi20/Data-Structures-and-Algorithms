// Problem Link: https://leetcode.com/problems/next-permutation/

/*
Problem:
You are given an array of integers nums.

Find the next lexicographically greater permutation
of the array.

If such an arrangement is not possible, rearrange the
array into the lowest possible order (ascending order).

You must modify the array in-place.

---

Example 1:

Input:
nums = [1,2,3]

Output:
[1,3,2]

Explanation:
The next permutation after [1,2,3] is [1,3,2].

---

Example 2:

Input:
nums = [3,2,1]

Output:
[1,2,3]

Explanation:
There is no greater permutation.

So, we return the smallest permutation:
[1,2,3]

---

Example 3:

Input:
nums = [1,1,5]

Output:
[1,5,1]

Explanation:
The next permutation after [1,1,5] is [1,5,1].
*/

public class Next_Permutation {

    // ==========================================================
    // Approach: Find Pivot + Swap + Reverse
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    //
    // Observation:
    //
    // We need to make the smallest possible change that
    // produces a permutation greater than the current one.
    //
    // Step 1:
    // Find the first index from the right where:
    //
    // nums[i] < nums[i + 1]
    //
    // This index is called the "pivot".
    //
    // Step 2:
    // If a pivot exists, find the smallest number greater
    // than nums[pivot] from the right side.
    //
    // Step 3:
    // Swap the pivot with that number.
    //
    // Step 4:
    // Reverse everything after the pivot.
    //
    // Why reverse?
    //
    // The elements after the pivot are in descending order.
    // After swapping, we need the smallest possible order
    // after the pivot, so we reverse them into ascending order.
    //
    // Example:
    //
    // nums = [1,2,3]
    //
    // Step 1:
    // Start from right:
    //
    // 2 < 3
    //
    // pivot = 1
    //
    // Step 2:
    // Find element greater than nums[1] = 2
    //
    // nums[2] = 3
    //
    // Step 3:
    // Swap:
    //
    // [1,3,2]
    //
    // Step 4:
    // Nothing left to reverse.
    //
    // Answer:
    // [1,3,2]
    //
    // ----------------------------------------------------------
    //
    // Example:
    //
    // nums = [1,2,5,4,3]
    //
    // Step 1:
    // Find pivot:
    //
    // 4 > 3
    // 5 > 4
    // 2 < 5
    //
    // pivot = 1
    //
    // Step 2:
    // Find the smallest number greater than 2 from the right.
    //
    // 3 is the correct element.
    //
    // Step 3:
    // Swap 2 and 3:
    //
    // [1,3,5,4,2]
    //
    // Step 4:
    // Reverse everything after index 1:
    //
    // [1,3,2,4,5]
    //
    // Answer:
    // [1,3,2,4,5]
    // ==========================================================

    public static void nextPermutation(int[] nums) {

        // ======================================================
        // Step 1: Find the pivot
        // ======================================================
        //
        // Find the first element from the right which is
        // smaller than the element immediately after it.
        //
        // Example:
        //
        // [1,2,5,4,3]
        //    ^
        //
        // 2 < 5
        //
        // pivot = 1
        // ======================================================

        int pivot = nums.length - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        // ======================================================
        // Step 2: If pivot exists
        // ======================================================
        //
        // Find the first element from the right which is
        // greater than nums[pivot].
        //
        // Because the right side is in descending order,
        // the first greater element we find is the smallest
        // possible element greater than the pivot.
        // ======================================================

        if (pivot >= 0) {

            int i = nums.length - 1;

            while (nums[i] <= nums[pivot]) {
                i--;
            }

            // Swap pivot with the next greater element
            swap(nums, pivot, i);
        }

        // ======================================================
        // Step 3: Reverse the elements after the pivot
        // ======================================================
        //
        // If pivot does not exist, the entire array is
        // in descending order.
        //
        // Example:
        //
        // [3,2,1]
        //
        // Reverse entire array:
        //
        // [1,2,3]
        //
        // This gives the smallest permutation.
        // ======================================================

        reverse(nums, pivot + 1, nums.length - 1);
    }

    // ==========================================================
    // Swap two elements
    // ==========================================================

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];

        nums[i] = nums[j];

        nums[j] = temp;
    }

    // ==========================================================
    // Reverse array from left to right
    // ==========================================================

    private static void reverse(int[] nums, int left, int right) {

        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }
    }

    // Driver Code
    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 4, 3};

        nextPermutation(nums);

        System.out.print("Next Permutation: [");

        for (int i = 0; i < nums.length; i++) {

            System.out.print(nums[i]);

            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}