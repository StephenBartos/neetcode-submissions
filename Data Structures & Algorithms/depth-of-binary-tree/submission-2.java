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
    public int maxDepth(TreeNode root) {
        // DFS (iterative)
        if (root == null) return 0;

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        nodeStack.push(root);
        depthStack.push(1);

        int maxDepth = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode n = nodeStack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (n.left != null) {
                nodeStack.push(n.left);
                depthStack.push(depth + 1);
            }
            if (n.right != null) {
                nodeStack.push(n.right);
                depthStack.push(depth + 1);
            }
        }
        return maxDepth;
    }
}
