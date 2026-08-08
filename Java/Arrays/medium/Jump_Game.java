// Problem Link: https://leetcode.com/problems/jump-game/

/*
Problem:
You are given an integer array nums.

Each element nums[i] represents the maximum jump length
from that position.

Return true if you can reach the last index,
otherwise return false.

------------------------------------------------------------

Example 1:

Input:
nums = [2,3,1,1,4]

Output:
true

Explanation:
Jump 1 step from index 0 to 1,
then 3 steps to the last index.

------------------------------------------------------------

Example 2:

Input:
nums = [3,2,1,0,4]

Output:
false

Explanation:
You will always reach index 3,
but cannot move further.
*/

public class Jump_Game {

    // ==========================================================
    // Approach: Greedy (Track Maximum Reach)
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    //
    // Observation:
    // Instead of trying all paths, keep track of the
    // maximum index you can reach so far.
    //
    // If at any index i:
    // i > maxReach → unreachable → return false
    //
    // Otherwise:
    // update maxReach = max(maxReach, i + nums[i])
    //
    // If maxReach reaches last index → return true
    //
    // Example:
    //
    // nums = [2,3,1,1,4]
    //
    // i=0 → maxReach = 2
    // i=1 → maxReach = 4
    // → reached end → true
    // ==========================================================

    public static boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is unreachable
            if (i > maxReach) {
                return false;
            }

            // Update max reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            // Early exit if last index is reachable
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    // Driver Code
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        boolean result = canJump(nums);

        System.out.println("Can Reach Last Index: " + result);
    }
}