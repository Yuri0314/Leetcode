/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
// 时间复杂度为O(kn×logk)
// 空间复杂度为O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int amount = lists.length;
        int interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i += 2 * interval)
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            interval *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
}
// @lc code=end

