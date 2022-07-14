package com.dsalgo.caches;

import com.dsalgo.linkedlist.DoublyNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * implement LRU algorithm in below ways -
 * 1. LRUCache where : cache will have limited capacity
 * set(key, value) will replace the least recently values if the capacity is more
 * get(key) will get the value if the key present, else return -1
 * <p>
 * 2. LRUSimple class where:
 * cache will have a size and inserting elements will replace old occurrences upon size
 * <p>
 * we will use a Hashmap and Queue
 *
 * @author Srinath.Rayabarapu
 */
public class LRUCacheMain {

    public static void main(String[] args) {

        // 1. LRU cache with key value pairs
        LRUCache cache = new LRUCache(2);

        cache.set(1, 10);
        cache.set(2, 20);
        // returns 10
        System.out.println("Value for the key: 1 is " + cache.get(1));

        // evicts key 2 and store a key (3) with
        // value 30 in the cache.
        cache.set(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)
        // evicts key 1 and store a key (4) with
        // value 40 in the cache.
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40


        System.out.println("-----------------------");


        // 2. simple LRU implementation with size restrictions
        LRUWithDeque lru = new LRUWithDeque(4);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(1);
        lru.add(4);
        lru.add(5);
        lru.display();
    }
}

class LRUCache {

    private DoublyNode head, tail;
    private int capacity, count;
    private Map<Integer, DoublyNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoublyNode(0, 0);
        tail = new DoublyNode(0, 0);
        head.previous = null;
        head.next = tail;
        tail.previous = head;
        tail.next = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyNode node = map.get(key);
            deleteNode(node);
            addToHead(node);
            System.out.printf("Found value %d for the key %d%n", node.value, key);
            return node.value;
        }
        System.out.printf("Didn't find any value for the key %d%n", key);
        // in case no key found in cache
        return -1;
    }

    private void addToHead(DoublyNode node) {
        node.next = head.next;
        node.next.previous = node;
        node.previous = head;
        head.next = node;
    }

    private void deleteNode(DoublyNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public void set(int key, int value) {
        DoublyNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            map.remove(key);
            deleteNode(node);
        } else {
            node = new DoublyNode(key, value);
            if (map.size() == capacity) {
                map.remove(tail.previous.key);
                deleteNode(tail.previous);
            }
        }
        addToHead(node);
        map.put(key, node);
    }

}

/**
 * LRU implementation class
 */
class LRUWithDeque {

    Deque<Integer> queue;
    int capacity = 0;

    LRUWithDeque(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    void add(Integer ele) {
        if (!queue.contains(ele)) {
            //add it
            if (queue.size() == capacity) {
                queue.removeLast();
            }
        } else {
            // check lru logic
            queue.remove(ele);
        }
        queue.push(ele);
    }

    void display() {
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}