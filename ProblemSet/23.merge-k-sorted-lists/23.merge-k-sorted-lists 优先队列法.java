import java.util.PriorityQueue;
import java.util.Queue;

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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, (node1, node2) -> node1.val - node2.val);
        for (ListNode list : lists) {
            if (list != null) heap.add(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            tail.next = heap.remove();
            tail = tail.next;
            if (tail.next != null) heap.add(tail.next);
        }
        return dummy.next;
    }
}
// @lc code=end

