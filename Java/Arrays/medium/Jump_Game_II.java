// Problem Link: https://leetcode.com/problems/jump-game-ii/

/*
Problem:
You are given an integer array nums.

Each element nums[i] represents the maximum jump length
from position i.

Return the minimum number of jumps required to reach
the last index.

You can assume that you can always reach the last index.

---

Example 1:

Input:
nums = [2,3,1,1,4]

Output:
2

Explanation:
Jump from index 0 -> 1
Jump from index 1 -> 4

Minimum jumps = 2

---

Example 2:

Input:
nums = [2,3,0,1,4]

Output:
2

Explanation:
Jump from index 0 -> 1
Jump from index 1 -> 4

Minimum jumps = 2
*/

public class Jump_Game_II {

    // ==========================================================
    // Approach: Greedy (Track Current End and Farthest Reach)
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    //
    // Observation:
    // Think of each jump as creating a "range" of indices
    // that can be reached with the current number of jumps.
    //
    // currentEnd:
    // The farthest index we can reach using the current
    // number of jumps.
    //
    // farthest:
    // The farthest index we can reach from all positions
    // inside the current range.
    //
    // When we reach currentEnd:
    // We must make another jump.
    //
    // Example:
    //
    // nums = [2,3,1,1,4]
    //
    // Start:
    // jumps = 0
    // currentEnd = 0
    // farthest = 0
    //
    // i = 0:
    // farthest = max(0, 0 + 2) = 2
    //
    // Reached currentEnd (0)
    // → make jump
    // jumps = 1
    // currentEnd = 2
    //
    // i = 1:
    // farthest = max(2, 1 + 3) = 4
    //
    // i = 2:
    // farthest = 4
    //
    // We can reach the last index.
    // Minimum jumps = 2
    // ==========================================================

    public static int jump(int[] nums) {

        int jumps = 0;

        // End of the range reachable with current jumps
        int currentEnd = 0;

        // Farthest index reachable from current range
        int farthest = 0;

        // No need to process the last index
        for (int i = 0; i < nums.length - 1; i++) {

            // Find the farthest position we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // We have reached the end of the current jump range
            if (i == currentEnd) {

                // We need one more jump
                jumps++;

                // Extend the range
                currentEnd = farthest;

                // Early exit if we can already reach the end
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    // Driver Code
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        int result = jump(nums);

        System.out.println("Minimum Jumps: " + result);
    }
}