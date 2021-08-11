/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Deque<Node> stack = new LinkedList<Node>();
        Node pre = null, head = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == null) head = root;
            else pre.right = root;
            root.left = pre;
            pre = root;
            root = root.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}