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
        // Iterative (BFS)
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                // Iterate over all the nodes at this level and add their children to the queue
                TreeNode n = queue.poll();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
        }

        return depth;
    }
}
