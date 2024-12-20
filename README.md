# cache_system_lowleveldesign

## **Introduction**
This project is a low-level design of a cache system. The cache is designed to support three fundamental operations:

1. **Put**: Allows storing a value against a key in the cache.
2. **Get**: Retrieves a previously stored value using the key.
3. **Eviction**: Automatically removes keys when the cache reaches its maximum capacity, following the Least Recently Used (LRU) eviction policy.

The design adheres to clean, professional-level coding standards, ensuring extensibility and scalability. Additionally, the implementation complies with SOLID principles to provide a modular and maintainable codebase.

---

## **Directory Structure**

```
Cache_Design
├── datastructures
│   ├── DoublyLinkedNode.java
│   ├── DoublyLinkedList.java
├── policies
│   ├── EvictionPolicy.java
│   ├── LRUCache.java
├── storage
│   ├── Storage.java
│   ├── HashMapBasedStorage.java
├── cache
│   ├── Cache.java
├── Main.java
```

- **`datastructures/`**: Contains classes for managing the LRU data structure.
  - `DoublyLinkedNode`: Represents a node in the doubly linked list.
  - `DoublyLinkedList`: Manages the LRU order efficiently.
- **`policies/`**: Contains the eviction logic.
  - `EvictionPolicy`: Interface for defining eviction policies.
  - `LRUCache`: Implements the Least Recently Used eviction strategy.
- **`storage/`**: Handles data storage mechanisms.
  - `Storage`: Interface for storage operations.
  - `HashMapBasedStorage`: Implements storage using a hash map.
- **`cache/`**: Integrates storage and eviction logic into a functional cache.
  - `Cache`: Unified implementation of the cache system.
- **`Main.java`**: Demonstrates the usage of the cache.

---

## **Design and Implementation**

### **Key Components**

#### 1. **Eviction Policy**
- **Interface**: Defines the methods `access()` and `evict()`.
- **Implementation**: LRU (Least Recently Used) policy using a doubly linked list and hash map to efficiently track the usage order of keys.

#### 2. **Data Structures**
- **DoublyLinkedNode**: Represents a node with pointers to its previous and next nodes.
- **DoublyLinkedList**: Supports efficient addition and removal of nodes for maintaining the LRU order.

#### 3. **Storage**
- **Interface**: Provides methods for `put`, `get`, and `delete` operations.
- **Implementation**: HashMap-based storage for O(1) key-value retrieval.

#### 4. **Cache**
- Combines storage and eviction policy.
- Handles `put` and `get` requests while ensuring keys are evicted when capacity is reached.

---

## **Code Snippets**

### **Eviction Policy Interface**
```java
public interface EvictionPolicy<K> {
    void access(K key);
    K evict();
}
```

### **DoublyLinkedList**
```java
public class DoublyLinkedList<K> {
    private DoublyLinkedNode<K> head, tail;
    public DoublyLinkedNode<K> add(K key) { ... }
    public DoublyLinkedNode<K> removeTail() { ... }
}
```

### **Cache**
```java
public class Cache<K, V> {
    private final Storage<K, V> storage;
    private final EvictionPolicy<K> evictionPolicy;

    public void put(K key, V value) { ... }
    public V get(K key) { ... }
}
```

---

## **Demonstration**
The `Main` class demonstrates the functionality of the cache system.

```java
public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>(new HashMapBasedStorage<>(3), new LRUCache<>());

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache.get(1)); // Outputs: A

        cache.put(4, "D");
        System.out.println(cache.get(2)); // Outputs: null (evicted)
    }
}
```

---

## **SOLID Principles in Design**

1. **Single Responsibility Principle**
   - Each class has a single responsibility, e.g., `DoublyLinkedList` manages the LRU queue, `HashMapBasedStorage` handles storage.

2. **Open/Closed Principle**
   - The `EvictionPolicy` interface allows adding new eviction strategies (e.g., MRU, LFU) without modifying existing code.

3. **Liskov Substitution Principle**
   - Any implementation of `EvictionPolicy` can replace the LRU implementation without breaking the cache.

4. **Interface Segregation Principle**
   - The interfaces like `Storage` and `EvictionPolicy` are specific to their purposes.

5. **Dependency Inversion Principle**
   - High-level modules (`Cache`) depend on abstractions (`Storage`, `EvictionPolicy`) rather than concrete implementations.

---

## **How to Run**

1. Clone the repository:
   ```bash
   git clone <repository-link>
   cd Cache_Design
   ```

2. Compile the code:
   ```bash
   javac -d . datastructures/DoublyLinkedNode.java datastructures/DoublyLinkedList.java
   javac -d . storage/Storage.java storage/HashMapBasedStorage.java
   javac -d . policies/EvictionPolicy.java policies/LRUCache.java
   javac -d . cache/Cache.java
   javac -d . Main.java
   ```

3. Run the program:
   ```bash
   java Main
   ```

---

## **Conclusion**
This project demonstrates a clean and extensible design for a cache system. By adhering to SOLID principles, the system is modular, scalable, and easy to maintain. Future extensions, such as adding new eviction strategies or storage mechanisms, can be implemented with minimal changes to the existing code.

