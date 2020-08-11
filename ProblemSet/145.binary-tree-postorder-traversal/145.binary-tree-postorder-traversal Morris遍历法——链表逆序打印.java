import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
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
    private List<Integer> ans = new LinkedList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) cur = cur.right;
            else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                else {
                    pre.right = null;
                    traverseEdge(cur.left);
                    cur = cur.right;
                }
            }
        }
        traverseEdge(root);
        return ans;
    }

    private void traverseEdge(TreeNode node) {
        TreeNode cur = reverseEdge(node);
        node = cur;
        while (cur != null) {
            ans.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(node);
    }

    private TreeNode reverseEdge(TreeNode node) {
        TreeNode pre = null, cur = node;
        while (cur != null) {
            node = cur.right;
            cur.right = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}
// @lc code=end

