import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Stack<TreeNodePair> stack = new Stack<TreeNodePair>();
        stack.push(new TreeNodePair(root, false));
        while (!stack.isEmpty()) {
            TreeNodePair pair = stack.pop();
            if (!pair.flag) {
                if (pair.node.right != null) stack.push(new TreeNodePair(pair.node.right, false));
                stack.push(new TreeNodePair(pair.node, true));
                if (pair.node.left != null) stack.push(new TreeNodePair(pair.node.left, false));
            }
            else {
                ans.add(pair.node.val);
            }
        }
        return ans;
    }

    private class TreeNodePair {
        TreeNode node;
        boolean flag;
        TreeNodePair(TreeNode node, boolean flag) {
            this.node = node;
            this.flag = flag;
        }
    }
}
// @lc code=end

