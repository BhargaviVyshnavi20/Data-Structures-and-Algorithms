/*
Problem Link:
https://leetcode.com/problems/majority-element/

Approach: Boyer-Moore Voting Algorithm

Maintain a candidate for the majority element and a counter.

Traverse the array:
- If the counter becomes 0, choose the current element as the new candidate.
- If the current element matches the candidate, increment the counter.
- Otherwise, decrement the counter.

The majority element appears more than n/2 times, so it cannot be completely
canceled out by the other elements. After one traversal, the remaining candidate
is the majority element.

- Time: O(n)
- Space: O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {

        int majority_element = 0;
        int count = 0;

        // Traverse the array
        for (int num : nums) {

            // Select a new candidate when count becomes 0
            if (count == 0) {
                majority_element = num;
                count = 1;
            }

            // Current element matches the candidate
            else if (majority_element == num) {
                count++;
            }

            // Current element is different from the candidate
            else {
                count--;
            }
        }

        return majority_element;
    }
}