// class Solution {
//     public String removeDuplicateLetters(String s) {
//         Set<Character> charSet = new TreeSet<>();
//         int n = s.length();
//         for(int i = 0;i<n;i++)
//         {
//             charSet.add(s.charAt(i));
//         }
//         StringBuffer result = new StringBuffer(charSet.size());
//         for(Character c : charSet)
//         {
//             result.append(c);
//         }
//         return result.toString();
//     }
// }
// 143/290 Testcases passed.
// Input:
// "cbacdcbc"
// Output:
// "abcd"
// Expected:
// "acdb"


class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // Store the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is already in the stack, skip it
            if (visited[c - 'a']) continue;

            // Pop characters from the stack if they are greater than the current character
            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            // Push the current character onto the stack and mark it as visited
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder(stack.size());
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}