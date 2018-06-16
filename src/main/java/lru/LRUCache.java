package lru;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Cache implementation with least-recent-used revocation policy.
 * Time complexity for put and get is O(1)
 */
public class LRUCache<K, V> {

    /**
     * custom implementation instead of HashMap is explore the logic how the object (DLL) is linked in between
     * linked list and hashmap
     */
    private LinkedList<DLL<K, V>>[] hashmap;
    private DLLContainer<K, V> list = new DLLContainer<>();
    private int size = 0;
    private final int cap;

    @SuppressWarnings("unchecked")
    public LRUCache(int capacity) {
        this.cap = capacity;
        // hashmap size is not necessary same as lru cache capacity
        int mapSize = Math.max(capacity / 2, 5);
        hashmap = (LinkedList<DLL<K,V>>[]) new LinkedList[mapSize];
        Arrays.setAll(hashmap, i -> new LinkedList<DLL<K, V>>());
    }

    public V get(K key) {
        DLL<K, V> node = getDLL(key);
        if (node == null) {
            return null;
        }
        list.remove(node);
        list.addFirst(node);
        return node.val;
    }

    public void put(K key, V value) {
        size++;
        DLL<K, V> node = getDLL(key);
        if (node != null) {
            size--;
            list.remove(node);
        } else {
            node = new DLL<>(key);
        }
        node.val = value; // value might have been changed for the key

        if (size > cap) {
            DLL<K, V> revokeNode = list.removeLast();
            assert revokeNode != null;
            hashmap[getKeyIndex(revokeNode.key)].remove(revokeNode);
        }
        hashmap[getKeyIndex(key)].addFirst(node);
        list.addFirst(node);
    }

    private int getKeyIndex(K key) {
        return Objects.hashCode(key) % hashmap.length;
    }

    private DLL<K, V> getDLL(K key) {
        for (DLL<K, V> node : hashmap[getKeyIndex(key)]) {
            if (Objects.equals(node.key, key)) return node;
        }
        return null;
    }

}

