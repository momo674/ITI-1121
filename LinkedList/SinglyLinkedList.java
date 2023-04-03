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

   public int size() {
    int size = 0;
    Node<E> p = head;
    while (p != null) {
        p = p.next;
        size++;
    }
	return size;
   }

   public boolean isEmpty() {
	return head == null;
   }

   public void add(E o) {
	if (o == null) { throw new NullPointerException("Can't add null to list"); }

	Node<E> newobject = new Node<E>(o, null);
	if (head == null) {
		head = newobject;
	}
	else {
		Node<E> cursor = head;
		while (cursor.next != null) {
			cursor = cursor.next;
		}
		cursor.next = newobject;
	   }
   }


   public E removeFirst() {
	   E saved_value = head.value;

	   Node<E> first = head;
	   head = head.next;

	   first.next = null;
	   first.value = null;

	   return saved_value;
   }

   public E removeLast(){
      if (isEmpty()) { throw new IllegalStateException("empty list"); }
      
      E savedElement;

      if (head.next == null) {
         savedElement = head.value;
         head = null;
      }

      else {
         Node<E> p = head;
         while (p.next.next != null) {
            p = p.next;
         }

         savedElement = p.next.value;
         p.next = null;
      }

      return savedElement;

   }

   public boolean remove(E o) {
      if (head == null) { return false;} //special case 1

      else {
         if (head.value.equals(o)) {head = head.next; return true;}

         else {
            Node<E> p = head;

            while (p.next != null && !p.next.value.equals(o)) {
               p = p.next;
            }

            if (p.next == null) { //means you are at the end of the linkedlist
               return false;
            }
            else {
               p.next = p.next.next;
               return true;
            }
         }
      }
   }

   public E get( int pos) {

      if (isEmpty()) { throw new IllegalStateException("Empty list");}
      if (pos < 0) {throw new IndexOutOfBoundsException(pos); }


      Node<E> p = head;

      for (int i = 0; i < pos; i++) {
         p = p.next;
         if (p == null) {
            throw new IndexOutOfBoundsException(pos);
         }
      }

      return p.value;
   }

}