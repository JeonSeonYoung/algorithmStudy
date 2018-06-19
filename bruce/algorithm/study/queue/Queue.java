package algorithm.study.queue;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    int size();
    void clear();
    boolean isEmpty();
    default boolean isFull() { return false; }

    default void print() {
        System.out.println(toString());
    }
    default String summary() { throw new RuntimeException("not implemented"); }
    default void printSummary() {
        System.out.println(summary());
    }
}
