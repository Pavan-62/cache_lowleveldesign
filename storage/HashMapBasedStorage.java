package storage;

import java.util.HashMap;

public class HashMapBasedStorage<K, V> implements Storage<K, V> {
    private final int capacity;
    private final HashMap<K, V> map;

    public HashMapBasedStorage(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    @Override
    public boolean isFull() {
        return map.size() >= capacity;
    }
}
