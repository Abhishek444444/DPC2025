// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

 class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;   // Both are null
        if (t1 == null || t2 == null) return false;  // One is null, the other is not
        if (t1.val != t2.val) return false;         // Values don't match
        
        // Check outer and inner pairings
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // Example usage with test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println("Example 1: " + solution.isSymmetric(root1)); // true

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println("Example 2: " + solution.isSymmetric(root2)); // false

        // Example 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("Example 3: " + solution.isSymmetric(root3)); // true

        // Example 4 (empty tree)
        System.out.println("Example 4: " + solution.isSymmetric(null)); // true
    }
}
