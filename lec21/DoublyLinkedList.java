public class DoublyLinkedList<E> implements List<E> {
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public E removeLast() {
        Node<E> toDelete = tail;
        E savedValue = toDelete.value;

        if (head.next == null) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.previous;
            tail.next = null;
        }

        toDelete.value = null;
        toDelete.next = null; 
        return savedValue;
    }
}