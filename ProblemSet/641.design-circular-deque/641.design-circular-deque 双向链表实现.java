/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {
    private DoubleListNode head;
    private DoubleListNode tail;
    private int size;
    private int curSize;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = new DoubleListNode(-1);
        tail = new DoubleListNode(-1);
        head.next = tail;
        tail.pre = head;
        size = k;
        curSize = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        DoubleListNode node = new DoubleListNode(value);
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        ++curSize;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        DoubleListNode node = new DoubleListNode(value);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        ++curSize;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head.next.next.pre = head;
        head.next = head.next.next;
        --curSize;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        --curSize;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : tail.pre.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curSize == size;
    }

    private class DoubleListNode {
        int val;
        DoubleListNode pre;
        DoubleListNode next;

        public DoubleListNode (int val) { this.val = val; }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

