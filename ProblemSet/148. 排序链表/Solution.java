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
    public ListNode sortList(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; ++len, p = p.next);
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            ListNode pre = dummy, cur = dummy.next;
            while (cur != null) {
                ListNode p1 = cur;
                for (int i = 1; i < subLen && cur.next != null; ++i) 
                    cur = cur.next;
                ListNode p2 = cur.next;
                cur.next = null;
                cur = p2;
                for (int i = 1; i < subLen && cur != null && cur.next != null; ++i)
                    cur = cur.next;
                ListNode tmp = null;
                if (cur != null) {
                    tmp = cur.next;
                    cur.next = null;
                }
                ListNode merged = merge(p1, p2);
                pre.next = merged;
                while (pre.next != null) pre = pre.next;
                cur = tmp;
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return dummy.next;
    }
}