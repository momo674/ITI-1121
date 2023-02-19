// public interface Stack{
//     public abstract boolean isEmpty();
//     public abstract Object push(Object o);
//     public abstract Object pop();
//     public abstract Object peek();
// }

public interface Stack<E> {
    public abstract boolean isEmpty();
    public abstract E push( E elem );
    public abstract E pop();
    public abstract E peek();
}
// an interface can also be paramterized