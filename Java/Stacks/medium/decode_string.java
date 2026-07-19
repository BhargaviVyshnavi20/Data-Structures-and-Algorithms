import java.util.Stack;

/*
Problem Link:
https://leetcode.com/problems/decode-string/

Approach: Two Stacks

Use one stack to store repetition counts and another stack to
store the previously built strings before entering a bracket.

Traverse the string character by character:
- Build the repeat count when digits are encountered.
- On '[', push the current count and string onto their stacks,
  then start building a new substring.
- On ']', pop the repeat count and previous string, append the
  current substring repeatedly, and continue.
- Append normal characters directly to the current string.

- Time: O(n)
- Space: O(n)
*/

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {

            // Build the repeat count
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            }

            // Start of an encoded substring
            else if (ch == '[') {
                countStack.push(count);
                stringStack.push(current);

                current = new StringBuilder();
                count = 0;
            }

            // End of an encoded substring
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            }

            // Normal character
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}