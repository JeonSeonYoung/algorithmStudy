package stack.useLinkedList;

public interface lStack {

    void push(Object data);
    Object pop();
    Object peek();
    Integer size();
    void clear();
    boolean isEmpty();
    boolean isFull();
}
