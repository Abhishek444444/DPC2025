import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // Stack to hold opening brackets
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If opening bracket → push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If closing bracket → check top of stack
            else {
                if (stack.isEmpty()) return false; // unmatched closing
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // mismatched pair
                }
            }
        }

        // If stack is empty → all matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isValid("()"));      // true
        System.out.println(sol.isValid("([)]"));    // false
        System.out.println(sol.isValid("[{()}]"));  // true
        System.out.println(sol.isValid(""));        // true
        System.out.println(sol.isValid("{[}"));     // false
    }
}
