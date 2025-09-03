import java.util.Stack;

class Solution {

    // Function to sort the stack using recursion
    public void sortStack(Stack<Integer> stack) {
        // Base case: empty stack
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop top element
        int top = stack.pop();

        // Step 2: Sort the remaining stack recursively
        sortStack(stack);

        // Step 3: Insert the popped element at correct position
        insertSorted(stack, top);
    }

    // Helper function to insert an element into a sorted stack
    private void insertSorted(Stack<Integer> stack, int value) {
        // Base case: stack is empty or top <= value
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        // Otherwise, pop top and recurse
        int top = stack.pop();
        insertSorted(stack, value);

        // Push the top back after inserting value
        stack.push(top);
    }

    // Main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        Stack<Integer> stack = new Stack<>();

        // Example test
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original stack: " + stack);
        sol.sortStack(stack);
        System.out.println("Sorted stack: " + stack);

        // Edge cases
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(7);
        stack2.push(1);
        stack2.push(5);
        sol.sortStack(stack2);
        System.out.println("Sorted stack2: " + stack2);

        Stack<Integer> stack3 = new Stack<>();
        sol.sortStack(stack3);
        System.out.println("Sorted empty stack: " + stack3);
    }
}
