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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.right == null) {
                ans.add(0, cur.val);
                cur = cur.left;
            }
            else {
                pre = cur.right;
                while (pre.left != null && pre.left != cur) pre = pre.left;
                if (pre.left == null) {
                    ans.add(0, cur.val);
                    pre.left = cur;
                    cur = cur.right;
                }
                else {
                    pre.left = null;
                    cur = cur.left;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

