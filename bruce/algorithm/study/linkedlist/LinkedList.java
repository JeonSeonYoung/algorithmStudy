package algorithm.study.linkedlist;

import java.util.Iterator;

public interface LinkedList<T> extends Iterator<T> {
    void addFirst(T value);
    void addLast(T value);
    void add(int index, T value);
    T removeFirst();
    T removeLast();
    T remove(int index);
    int size();
    void clear();
    int indexOf(T value);
    boolean contains(T value);
}
