// Problem Link:
// https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

public class assign_cookies {

    // ==========================================================
    // Approach: Sorting + Two Pointers
    // Difficulty  : Easy
    // Data Structure: Array
    // Time Complexity : O(N log N + M log M)
    // Space Complexity: O(1)
    //
    // Idea:
    // Sort children by greed and cookies by size.
    //
    // Try to give the smallest possible cookie to each child.
    //
    // If cookie can satisfy the child -> move both pointers.
    // If cookie is too small -> move cookie pointer.
    // ==========================================================

    public static int findContentChildren(int[] g, int[] s) {

        // Step 1: Sort the array
        Arrays.sort(g);

        // Step 2: Sort the array
        Arrays.sort(s);

        // Step 3: Two pointers
        int child = 0;
        int cookie = 0;

        int satisfied = 0;

        // Step 4: Find maximum satisfied children
        while (child < g.length && cookie < s.length) {

            // Cookie can satisfy the current child
            if (s[cookie] >= g[child]) {
                child++;
                cookie++;
                satisfied++;
            }

            // Cookie is too small
            else {
                cookie++;
            }
        }

        return satisfied;
    }

    // Driver Code
    public static void main(String[] args) {

        int[] g = {1, 2, 3};

        int[] s = {1, 1};

        int result = findContentChildren(g, s);

        System.out.println("Maximum Satisfied Children: " + result);
    }
}