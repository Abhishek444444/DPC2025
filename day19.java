import java.util.*;

class Solution {
    public int evalPostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.trim().split("\\s+"); // Split by spaces

        for (String token : tokens) {
            // If token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop(); // right operand
                int a = stack.pop(); // left operand
                int result = 0;

                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break; // truncates towards zero
                }
                stack.push(result);
            } else {
                // Operand → push to stack
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop(); // Final result
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.evalPostfix("2 1 + 3 *")); // 9
        System.out.println(sol.evalPostfix("5 6 +"));     // 11
        System.out.println(sol.evalPostfix("-5 6 -"));    // -11
        System.out.println(sol.evalPostfix("15 7 1 1 + - / 3 * 2 1 1 + + -")); // 5
        System.out.println(sol.evalPostfix("5"));         // 5
    }
}
