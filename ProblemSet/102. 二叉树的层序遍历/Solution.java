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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        cur.offer(root);
        while (!cur.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int n = cur.size();
            for (int i = 0; i < n; ++i) {
                TreeNode node = cur.poll();
                level.add(node.val);
                if (node.left != null) cur.add(node.left);
                if (node.right != null) cur.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}