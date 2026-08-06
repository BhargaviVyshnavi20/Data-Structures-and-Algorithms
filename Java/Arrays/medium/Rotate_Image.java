// Problem Link: https://leetcode.com/problems/rotate-image/

/*
Problem:
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place,
which means you have to modify the input matrix directly.
DO NOT allocate another 2D matrix.

Example 1:
Input:
matrix =
[
 [1,2,3],
 [4,5,6],
 [7,8,9]
]

Output:
[
 [7,4,1],
 [8,5,2],
 [9,6,3]
]

------------------------------------------------------------

Example 2:
Input:
matrix =
[
 [5,1,9,11],
 [2,4,8,10],
 [13,3,6,7],
 [15,14,12,16]
]

Output:
[
 [15,13,2,5],
 [14,3,4,1],
 [12,6,8,9],
 [16,7,10,11]
]
*/

import java.util.Arrays;

public class Rotate_Image {

    // ==========================================================
    // Approach: Transpose + Reverse Each Row
    // ==========================================================
    // Time Complexity : O(N²)
    // Space Complexity: O(1)
    //
    // Observation:
    // A 90-degree clockwise rotation can be achieved in two steps:
    //
    // 1. Transpose the matrix
    //    (Swap matrix[i][j] with matrix[j][i])
    //
    // 2. Reverse every row.
    //
    // Example:
    //
    // Original:
    // 1 2 3
    // 4 5 6
    // 7 8 9
    //
    // After Transpose:
    // 1 4 7
    // 2 5 8
    // 3 6 9
    //
    // After Reversing Rows:
    // 7 4 1
    // 8 5 2
    // 9 6 3
    // ==========================================================

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);

        System.out.println("Rotated Matrix:");

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}