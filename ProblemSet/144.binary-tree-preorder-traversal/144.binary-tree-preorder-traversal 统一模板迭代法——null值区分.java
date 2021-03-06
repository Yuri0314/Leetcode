import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root != null) {
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);
                stack.push(root);
                stack.push(null);
            }
            else ans.add(stack.pop().val);
        }
        return ans;
    }
}
// @lc code=end

