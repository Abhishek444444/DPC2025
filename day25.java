class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

 class Solution {

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true; // An empty tree is valid
        }

        if (node.val <= minVal || node.val >= maxVal) {
            return false; // Violates the BST property
        }

        // Validate left and right subtrees
        return validate(node.left, minVal, node.val) && 
               validate(node.right, node.val, maxVal);
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test Case 1: " + sol.isValidBST(root1)); // Output: true

        // Test Case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test Case 2: " + sol.isValidBST(root2)); // Output: false

        // Test Case 3
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println("Test Case 3: " + sol.isValidBST(root3)); // Output: false
    }
}
