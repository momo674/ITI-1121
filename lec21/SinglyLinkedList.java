public class SinglyLinkedList<E> implements List<E> {
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    private Node<E> head;
    private Node<E> tail;
   
    public void addLast(E elem) {
        Node<E> newNode = new Node<E>(elem, null);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    
    public E removeFirst() {
        //precondidtion: list is not empty
        Node<E> nodeToDelete = head;
        E result = nodeToDelete.value;
        head = head.next;
        head.value = null;
        nodeToDelete.value = null;
        nodeToDelete.next = null;
        if ( head == null) {
            tail = null;
        }

        return result;
    }
}