package algorithm.study.queue;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CircularQueue<T> implements Queue<T> {

    Object[] data;

    private int head;
    private int tail;

    private int maxSize;

    public CircularQueue(int size) {
        maxSize = size + 1;
        data = new Object[maxSize];
        head = tail = 0;
    }

    @Override
    public void enqueue(T value) {
        if (isFull())
            throw new IndexOutOfBoundsException("is full");
        data[tail++] = value;
        tail = tail % maxSize;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        T result = (T) data[head++];
        head = head % maxSize;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        return (T) data[head];
    }

    @Override
    public int size() {
        return actualTail() - head;
    }

    @Override
    public void clear() {
        data = new Object[maxSize];
        head = tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return size() == maxSize - 1;
    }

    @Override
    public String toString() {
        return "[" +
                IntStream.range(head, actualTail())
                        .map(i -> i % maxSize)
                        .mapToObj(idx -> data[idx])
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + "], size : " + this.size()
                + ", isEmpty : " + this.isEmpty()
                + ", isFull : " + this.isFull()
                ;
    }

    private int actualTail() {
        return (tail >= head) ? tail : tail + maxSize;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new CircularQueue<>(3);

        queue.print();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.print();

        queue.dequeue();
        queue.dequeue();

        queue.print();

        System.out.println(queue.peek());
        queue.print();

        queue.enqueue(4);
        queue.enqueue(5);

        queue.print();

        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();

        queue.clear();
        queue.print();

    }
}
