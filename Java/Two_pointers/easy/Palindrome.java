/*
Problem:
Given a string, check whether it is a palindrome.

A palindrome is a string that reads the same
forward and backward.

Example 1:
Input:
pop

Output:
Palindrome

Example 2:
Input:
Papa

Output:
None

Explanation:
Compare characters from the beginning and the end
of the string. If every pair matches, the string
is a palindrome; otherwise, it is not.
*/

import java.util.*;

public class Palindrome {

    // ==========================================================
    // Approach: Two-Pointer Comparison
    // ==========================================================
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    //
    // Compare the first and last characters of the string.
    // Move the left pointer forward and the right pointer
    // backward after every successful comparison.
    //
    // If any pair of characters is different,
    // the string is not a palindrome.
    // ==========================================================

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        if (isPalindrome(s)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("None");
        }

        sc.close();
    }
}