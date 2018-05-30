package list;

public interface lList {

    void addFirst(Object data);
    void addLast(Object data);
    void add(int idx, Object data);
    void removeFirst();
    void removeLast();
    void remove(int idx);
    Object get(int idx);
    Boolean contains(Object data);
    int size();
    void clear();
    int indexOf(Object data);

}
