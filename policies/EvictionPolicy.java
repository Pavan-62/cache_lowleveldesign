package policies;

public interface EvictionPolicy<K> {
    void keyAccessed(K key); // Correct method signature
    K evictKey();
    void evictSpecific(K key);
}
