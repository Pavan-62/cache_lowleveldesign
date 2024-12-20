import cache.Cache;
import policies.LRUCache;
import storage.HashMapBasedStorage;

public class Main {
    public static void main(String[] args) {
        // Initialize the Cache with LRU Eviction Policy and a capacity of 3
        Cache<Integer, String> cache = new Cache<>(new LRUCache<>(), new HashMapBasedStorage<>(3));

        // Add entries to the cache
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        // Retrieve and print values
        System.out.println("Get 1: " + cache.get(1)); // Should print "One"

        // Add another entry, causing eviction of the least recently used key (2)
        cache.put(4, "Four");

        // Test the evictions
        System.out.println("Get 2: " + cache.get(2)); // Should print "null" (evicted)
        System.out.println("Get 3: " + cache.get(3)); // Should print "Three"
        System.out.println("Get 4: " + cache.get(4)); // Should print "Four"

        // Access key 1 again to make it most recently used
        System.out.println("Get 1: " + cache.get(1)); // Should print "One"

        // Add another entry, causing eviction of the least recently used key (3)
        cache.put(5, "Five");

        // Final state of the cache
        System.out.println("Get 3: " + cache.get(3)); // Should print "null" (evicted)
        System.out.println("Get 5: " + cache.get(5)); // Should print "Five"
        System.out.println("Get 1: " + cache.get(1)); // Should print "One"
    }
}
