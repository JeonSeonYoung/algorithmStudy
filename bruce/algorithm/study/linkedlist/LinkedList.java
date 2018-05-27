package algorithm.study.linkedlist;

import java.util.Iterator;

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

    default void print() {
        System.out.println(toString());
    }
}
