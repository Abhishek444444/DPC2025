import java.util.Stack;

class ReverseStack {
    
    // Function to reverse the stack using recursion
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        // Step 1: Pop the top element
        int top = stack.pop();
        
        // Step 2: Recursively reverse the remaining stack
        reverse(stack);
        
        // Step 3: Insert the popped element at the bottom
        insertAtBottom(stack, top);
    }
    
    // Helper function to insert element at bottom of stack
    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        
        // Pop all elements until stack is empty
        int top = stack.pop();
        insertAtBottom(stack, x);
        
        // Push elements back after inserting x at bottom
        stack.push(top);
    }
    
    // Main function for testing
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
