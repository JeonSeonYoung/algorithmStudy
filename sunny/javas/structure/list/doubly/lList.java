package javas.list.doubly;

public interface lList {

    void addFirst(Object obj);
    void addLast(Object obj);
    void removeFirst();
    void removeLast();
    void add(int idx, Object obj);
    void remove(int idx);
    int size();
    void clear();
    Boolean isEmpty();
    int indexOf(Object obj);
    Boolean contains(Object obj);

}
