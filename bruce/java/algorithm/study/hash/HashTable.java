package algorithm.study.hash;

public interface HashTable<T> {
    boolean contains(T key);
    void removeKey(T key);
    int collisionMaxCount();
    void put(T key);
    void clear();
}
