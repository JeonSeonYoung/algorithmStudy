package algorithm.study.queue;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    int size();
    void clear();
    boolean isEmpty();
    boolean isFull();

    default void print() {
        System.out.println(toString());
    }
}
