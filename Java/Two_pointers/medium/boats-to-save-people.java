// Problem Link:
// https://leetcode.com/problems/boats-to-save-people/

import java.util.Arrays;

public class boats_to_save_people {

    // ==========================================================
    // Problem: Boats to Save People
    // ==========================================================
    //
    // You are given an array people where people[i] represents
    // the weight of the i-th person.
    //
    // Each boat can carry at most TWO people.
    //
    // The total weight of people in a boat cannot exceed limit.
    //
    // Return the minimum number of boats required to save
    // everyone.
    //
    // Example:
    //
    // people = [1,2]
    // limit = 3
    //
    // Answer = 1
    //
    // Both people can fit:
    // 1 + 2 = 3
    //
    // ----------------------------------------------------------
    //
    // Example:
    //
    // people = [3,2,2,1]
    // limit = 3
    //
    // Answer = 3
    //
    // Boats:
    //
    // [1,2]
    // [2]
    // [3]
    //
    // ==========================================================


    // ==========================================================
    // Approach: Sorting + Two Pointers
    // ==========================================================
    //
    // Time Complexity : O(N log N)
    // Space Complexity: O(1) auxiliary space
    //                   (ignoring sorting implementation)
    //
    // Observation:
    //
    // We want to put TWO people in a boat whenever possible.
    //
    // After sorting:
    //
    // [1, 2, 2, 3]
    //
    // We keep two pointers:
    //
    // left  -> lightest person
    // right -> heaviest person
    //
    // Step 1:
    // If the lightest + heaviest person can fit:
    //
    // people[left] + people[right] <= limit
    //
    // Then put both in the same boat.
    //
    // Move both pointers.
    //
    // Step 2:
    // If they cannot fit:
    //
    // people[left] + people[right] > limit
    //
    // The heaviest person cannot pair with ANYONE else,
    // because everyone else is at least as heavy as
    // the lightest person.
    //
    // Therefore, the heaviest person must go alone.
    //
    // Move only right.
    //
    // Every iteration uses exactly one boat.
    //
    // ==========================================================


    public static int numRescueBoats(int[] people, int limit) {

        // ======================================================
        // Step 1: Sort the people
        // ======================================================
        //
        // Example:
        //
        // [3,2,2,1]
        //
        // becomes:
        //
        // [1,2,2,3]
        //
        // ======================================================

        Arrays.sort(people);


        // ======================================================
        // Step 2: Create two pointers
        // ======================================================
        //
        // left:
        // Points to the lightest person.
        //
        // right:
        // Points to the heaviest person.
        //
        // ======================================================

        int left = 0;
        int right = people.length - 1;

        int boats = 0;


        // ======================================================
        // Step 3: Process people using two pointers
        // ======================================================
        //
        // Each iteration represents one boat.
        //
        // ======================================================

        while (left <= right) {

            // ==================================================
            // Check if the lightest and heaviest can share
            // the same boat.
            // ==================================================

            if (people[left] + people[right] <= limit) {

                // Both people are placed in this boat.

                left++;
                right--;

            } else {

                // ==================================================
                // The heaviest person cannot fit with the
                // lightest person.
                //
                // Therefore, the heaviest person cannot fit
                // with anyone else either.
                //
                // So the heaviest person gets a boat alone.
                // ==================================================

                right--;
            }

            // One boat has been used.

            boats++;
        }


        // ======================================================
        // Step 4: Return minimum number of boats
        // ======================================================

        return boats;
    }


    // ==========================================================
    // Driver Code
    // ==========================================================

    public static void main(String[] args) {

        int[] people = {3, 2, 2, 1};

        int limit = 3;

        int result = numRescueBoats(people, limit);

        System.out.println("Minimum Boats: " + result);
    }
}