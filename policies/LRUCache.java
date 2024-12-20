package policies;

import datastructures.DoublyLinkedList;
import datastructures.DoublyLinkedNode;
import java.util.HashMap;

public class LRUCache<K> implements EvictionPolicy<K> {
    private final DoublyLinkedList<K> dll;
    private final HashMap<K, DoublyLinkedNode<K>> map;

    public LRUCache() {
        this.dll = new DoublyLinkedList<>();
        this.map = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if (map.containsKey(key)) {
            DoublyLinkedNode<K> node = map.get(key);
            dll.remove(node);
            map.put(key, dll.add(key));
        } else {
            DoublyLinkedNode<K> newNode = dll.add(key);
            map.put(key, newNode);
        }
    }

    @Override
    public K evictKey() {
        DoublyLinkedNode<K> node = dll.removeTail();
        if (node != null) {
            map.remove(node.data);
            return node.data;
        }
        return null;
    }

    @Override
    public void evictSpecific(K key) {
        if (map.containsKey(key)) {
            DoublyLinkedNode<K> node = map.get(key);
            dll.remove(node);
            map.remove(key);
        }
    }
}
