import java.util.HashMap;

/*
Problem Link:
https://leetcode.com/problems/valid-anagram/

Approach: HashMap (Character Frequency Count)

If the two strings have different lengths, they cannot be anagrams.

Use a HashMap to store the frequency of each character in the first string.

Traverse the first string:
- Increment the frequency of each character.

Traverse the second string:
- If a character is not present in the map or its frequency is already zero,
  the strings are not anagrams.
- Otherwise, decrement its frequency.

If all characters are processed successfully, the strings are anagrams.

- Time: O(n)
- Space: O(k), where k is the number of distinct characters.
*/

class Solution {
    public boolean isAnagram(String s, String t) {

        // Strings of different lengths cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> s_map = new HashMap<>();

        // Count the frequency of each character in s
        for (char ch : s.toCharArray()) {
            s_map.put(ch, s_map.getOrDefault(ch, 0) + 1);
        }

        // Match each character in t against the frequency map
        for (char ch : t.toCharArray()) {

            // Character not found or already exhausted
            if (!s_map.containsKey(ch) || s_map.get(ch) == 0) {
                return false;
            }

            // Decrement the frequency
            s_map.put(ch, s_map.get(ch) - 1);
        }

        return true;
    }
}