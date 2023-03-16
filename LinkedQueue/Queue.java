public interface Queue<E> {
    public abstract boolean isEmpty();
    public abstract void enqueue(E newElement);
    public abstract E dequeue();
}