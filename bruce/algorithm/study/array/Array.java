package algorithm.study.array;


public interface Array<T> {
    Array<T> add(T val);

    Array<T> add(T val, int index);

    Array<Object> remove(int index);

    void clear();

    int size();

    // index
    int find(T object);

    T get(int index);

    void set(T val, int index);

    void swap(int index1, int index2);


}
