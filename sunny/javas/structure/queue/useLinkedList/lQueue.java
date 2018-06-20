package queue.useLinkedList;

public interface lQueue {
    Boolean isEmpty();
    Boolean isFull();
    Object peek();
    void remove();
    void insert(Object data);
    int size();
}
