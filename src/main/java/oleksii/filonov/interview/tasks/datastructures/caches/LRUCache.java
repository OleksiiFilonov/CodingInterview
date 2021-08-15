package oleksii.filonov.interview.tasks.datastructures.caches;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private final int capacity;

    private Map<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(-1, -1);
        this.tail = new Node(-2, -2);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addAtFront(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node existingNode = map.get(key);
        if(existingNode == null) {
            if(map.size() == capacity) {
                //resize to accomodate a new element
                Node toRemove = tail.prev;
                toRemove.prev.next = tail;
                tail.prev = toRemove.prev;
                map.remove(toRemove.key);
                addNew(key, value);
            } else {
                addNew(key, value);
            }
        } else {
            existingNode.prev.next = existingNode.next;
            existingNode.next.prev = existingNode.prev;
            existingNode.value = value;
            addAtFront(existingNode);
        }
    }

    private void addNew(int key, int value) {
        Node toAdd = new Node(key, value);
        addAtFront(toAdd);
        map.put(key, toAdd);
    }

    private void addAtFront(Node node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    private class Node {

        private final int key;
        private int value;
        private Node next;
        private Node prev;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
