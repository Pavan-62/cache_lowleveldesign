package datastructures;

public class DoublyLinkedNode<K> {
    public K data;
    public DoublyLinkedNode<K> prev;
    public DoublyLinkedNode<K> next;

    public DoublyLinkedNode(K data) {
        this.data = data;
    }
}
