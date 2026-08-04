/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private record TreeInfo(boolean isBalanced, int height) {}

    public boolean isBalanced(TreeNode root) {
        // Recursive DFS
        return dfs(root).isBalanced();
    }

    public TreeInfo dfs(TreeNode root) {
        if (root == null) {
            return new TreeInfo(true, 0);
        }

        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);

        boolean isBalanced = left.isBalanced
                                && right.isBalanced
                                && Math.abs(left.height - right.height) <= 1;
        int height = 1 + Math.max(left.height, right.height);
        return new TreeInfo(isBalanced, height);
    }

}
