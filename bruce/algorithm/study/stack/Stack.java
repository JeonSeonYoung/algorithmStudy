package algorithm.study.stack;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stack<T> {

    Object[] data;
    int maxSize;
    int index = 0;

    public Stack(int size) {
        data = new Object[size];
        maxSize = size;
    }

    public void push(T value) {
        if (isFull())
            throw new IndexOutOfBoundsException("is full");
        data[index++] = value;
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        return (T) data[--index];
    }

    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        return (T) data[index - 1];
    }

    public long size() {
        return index;
    }

    public void clear() {
        data = new Object[maxSize];
        index = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == maxSize;
    }

    @Override
    public String toString() {
        return "[" +
                IntStream.range(0, index)
                        .mapToObj(idx -> data[idx])
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + "], size : " + this.size()
                + ", isEmpty : " + this.isEmpty()
                + ", isFull : " + this.isFull()
                ;
    }

    public void print() {
        System.out.println(toString());
    }

    // test client
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);

        stack.print();
        IntStream.range(0, 5).forEach(
                stack::push
        );

        stack.print();
        //stack.push(100); // java.lang.IndexOutOfBoundsException: is full

        IntStream.range(0, 5).forEach(
                i -> stack.pop()
        );

        stack.print();

        //stack.pop(); // java.lang.IndexOutOfBoundsException: is empty
        //stack.peek();  // java.lang.IndexOutOfBoundsException: is empty

        IntStream.range(0, 2).forEach(
                stack::push
        );

        stack.print();
    }
}
