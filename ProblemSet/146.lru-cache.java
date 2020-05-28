import java.util.HashMap;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    private HashMap<Integer, DLinkNode> map;
    private DLinkNode head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DLinkNode>();
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkNode node = map.get(key);
            moveToTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkNode node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            DLinkNode node = new DLinkNode(key ,value);
            if (map.size() == capacity) {
                map.remove(head.next.key);
                popHead();
            }
            map.put(key, node);
            addToTail(node);
        }
    }

    private class DLinkNode {
        int key;
        int value;
        DLinkNode pre = null, next = null;

        DLinkNode () {}

        DLinkNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void removeNode (DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToTail (DLinkNode node) {
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }

    private void moveToTail (DLinkNode node) {
        removeNode(node);
        addToTail(node);
    }

    private void popHead () {
        removeNode(head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

