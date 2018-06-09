package algorithm.study.linkedlist;

public interface LinkedList<T> extends Iterable<T> {
    void addFirst(T value);
    void addLast(T value);
    void add(int index, T value);
    T removeFirst();
    T removeLast();
    T remove(int index);
    int size();
    void clear();
    boolean isEmpty();
    int indexOf(T value);
    boolean contains(T value);

    default T getFirst() { throw new RuntimeException("not implemented"); }
    default T getLast() { throw new RuntimeException("not implemented"); }

    default void print() {
        System.out.println(toString());
    }
    default String summary() { throw new RuntimeException("not implemented"); }
    default void printSummary() {
        System.out.println(summary());
    }
}
