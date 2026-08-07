// Problem Link: https://leetcode.com/problems/set-matrix-zeroes/

/*
Problem:
Given an m x n integer matrix.

If an element is 0,
set its entire row and column to 0.

You must do it in-place.

Example 1:

Input:
matrix =
[
 [1,1,1],
 [1,0,1],
 [1,1,1]
]

Output:
[
 [1,0,1],
 [0,0,0],
 [1,0,1]
]

------------------------------------------------------------

Example 2:

Input:
matrix =
[
 [0,1,2,0],
 [3,4,5,2],
 [1,3,1,5]
]

Output:
[
 [0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]
]
*/

import java.util.Arrays;

public class Set_Matrix_Zeroes {

    // ==========================================================
    // Approach: Use First Row & First Column as Markers
    // ==========================================================
    // Time Complexity : O(M × N)
    // Space Complexity: O(1)
    //
    // Observation:
    // Instead of using extra arrays to store rows and columns
    // that should become zero, use:
    //
    // - First row as column markers
    // - First column as row markers
    //
    // Since matrix[0][0] belongs to both first row and first
    // column, use an additional boolean variable to remember
    // whether the first column should become zero.
    //
    // Algorithm:
    //
    // Step 1:
    // Traverse the matrix.
    // Whenever matrix[i][j] == 0:
    //
    // - Mark its row:
    //      matrix[i][0] = 0
    //
    // - Mark its column:
    //      matrix[0][j] = 0
    //
    // Step 2:
    // Traverse the matrix from bottom-right
    // (excluding first row and first column).
    //
    // If either row marker or column marker is zero,
    // make the current cell zero.
    //
    // Step 3:
    // If first column originally had a zero,
    // make the entire first column zero.
    //
    // Example:
    //
    // Original:
    // 1 1 1
    // 1 0 1
    // 1 1 1
    //
    // After Marking:
    // 1 0 1
    // 0 0 1
    // 1 1 1
    //
    // Final:
    // 1 0 1
    // 0 0 0
    // 1 0 1
    // ==========================================================

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstColZero = false;

        // Step 1: Mark rows and columns
        for (int i = 0; i < m; i++) {

            if (matrix[i][0] == 0)
                firstColZero = true;

            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Update matrix using markers
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 1; j--) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            // Step 3: Handle first column
            if (firstColZero) {
                matrix[i][0] = 0;
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroes(matrix);

        System.out.println("Matrix After Setting Zeroes:");

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}