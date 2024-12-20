package cache;

import policies.EvictionPolicy;
import storage.Storage;

public class Cache<K, V> {
    private final EvictionPolicy<K> evictionPolicy;
    private final Storage<K, V> storage;

    public Cache(EvictionPolicy<K> evictionPolicy, Storage<K, V> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(K key, V value) {
        if (storage.isFull()) {
            K evictedKey = evictionPolicy.evictKey();
            if (evictedKey != null) {
                storage.remove(evictedKey);
            }
        }
        storage.put(key, value);
        evictionPolicy.keyAccessed(key); 
    }

    public V get(K key) {
        V value = storage.get(key);
        if (value != null) {
            evictionPolicy.keyAccessed(key);
        }
        return value;
    }
}
