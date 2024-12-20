package datastructures;

public class DoublyLinkedList<K> {
    private DoublyLinkedNode<K> head;
    private DoublyLinkedNode<K> tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedNode<>(null);
        this.tail = new DoublyLinkedNode<>(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public DoublyLinkedNode<K> add(K data) {
        DoublyLinkedNode<K> newNode = new DoublyLinkedNode<>(data);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        return newNode;
    }

    public void remove(DoublyLinkedNode<K> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DoublyLinkedNode<K> removeTail() {
        if (tail.prev == head) {
            return null;
        }
        DoublyLinkedNode<K> lastNode = tail.prev;
        remove(lastNode);
        return lastNode;
    }
}
