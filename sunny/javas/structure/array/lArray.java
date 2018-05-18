package javas.Array;

public interface lArray {

    void add(int idx, Object data);
    void add(Object data);
    void remove(int idx);
    Object get(int idx);
    int size();
    void clear();
    void replace(int idx, Object data);
    void swap(int idx1, int idx2);
    int find(Object data);

}
