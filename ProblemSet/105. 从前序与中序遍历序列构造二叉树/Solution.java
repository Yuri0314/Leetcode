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
    private Map<Integer, Integer> idxMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) idxMap.put(inorder[i], i);
        return recursiveBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursiveBuild(int[] preorder, int preStart, int preEnd,
                                    int[] inorder, int inStart, int inEnd) 
    {
        if (preStart > preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = idxMap.get(rootVal);
        int leftLen = rootIdx - inStart;
        root.left = recursiveBuild(preorder, preStart + 1, preStart + leftLen, inorder, inStart, rootIdx - 1);
        root.right = recursiveBuild(preorder, preStart + leftLen + 1, preEnd, inorder, rootIdx + 1, inEnd);
        return root;
    }
}