// Problem Link:
// https://leetcode.com/problems/boats-to-save-people/

import java.util.Arrays;

public class boats_to_save_people {

    // ==========================================================
    // Approach: Sorting + Two Pointers
    // Time Complexity : O(N log N)
    // Space Complexity: O(1)
    //
    // Idea:
    // Pair the heaviest person with the lightest person.
    //
    // If they fit -> move both pointers.
    // If they don't -> heaviest person goes alone.
    // ==========================================================

    public static int numRescueBoats(int[] people, int limit) {

        // Step 1: Sort the array
        Arrays.sort(people);

        // Step 2: Two pointers
        int left = 0;
        int right = people.length - 1;

        int boats = 0;

        // Step 3: Find minimum boats
        while (left <= right) {

            // Lightest + heaviest can share a boat
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }

            // Heaviest person goes alone
            else {
                right--;
            }

            boats++;
        }

        return boats;
    }

    // Driver Code
    public static void main(String[] args) {

        int[] people = {3, 2, 2, 1};

        int limit = 3;

        int result = numRescueBoats(people, limit);

        System.out.println("Minimum Boats: " + result);
    }
}