import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.left != null && root.left != pre && root.right != pre) stack.push(root.left);
            else if (root.right != null && root.right != pre) stack.push(root.right);
            else {
                ans.add(stack.pop().val);
                pre = root;
            }
        }
        return ans;
    }
}
// @lc code=end

