class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both sides returned non-null, root is LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Else return the non-null child
        return left != null ? left : right;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Example tree setup
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution sol = new Solution();

        // Test Case 1
        TreeNode p1 = root.left;        // Node 5
        TreeNode q1 = root.left.right.right; // Node 4
        System.out.println("LCA of 5 and 4: " + sol.lowestCommonAncestor(root, p1, q1).val); // Output: 5

        // Test Case 2
        TreeNode p2 = root.left; // Node 5
        TreeNode q2 = root.right; // Node 1
        System.out.println("LCA of 5 and 1: " + sol.lowestCommonAncestor(root, p2, q2).val); // Output: 3

        // Test Case 3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        TreeNode p3 = root2;      // Node 1
        TreeNode q3 = root2.left; // Node 2
        System.out.println("LCA of 1 and 2: " + sol.lowestCommonAncestor(root2, p3, q3).val); // Output: 1
    }
}
