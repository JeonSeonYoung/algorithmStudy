package algorithm.study.stack;

public interface Stack<T> {
    void push(T value);
    T pop();
    T peek();
    long size();
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
