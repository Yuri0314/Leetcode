/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        for (ListNode p = head; p != null; ++count, p = p.next) ;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, tail = head;
        for (int t = count / k; t != 0; --t) {
            for (int i = 1; i < k; ++i) {
                ListNode tmp = tail.next.next;
                tail.next.next = pre.next;
                pre.next = tail.next;
                tail.next = tmp;
            }
            pre = tail;
            tail = tail.next;
        }
        return dummy.next;
    }
}
// @lc code=end

