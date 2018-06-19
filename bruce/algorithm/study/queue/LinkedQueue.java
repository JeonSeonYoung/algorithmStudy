package algorithm.study.queue;

import algorithm.study.linkedlist.DoublyLinkedList;
import algorithm.study.linkedlist.LinkedList;
import algorithm.study.linkedlist.SinglyLinkedList;
import algorithm.study.stack.LinearStack;
import algorithm.study.stack.LinkedStack;
import algorithm.study.stack.Stack;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static algorithm.study.util.LapUtil.check;

public class LinkedQueue<T> implements Queue<T> {

    private LinkedList<T> data;

    public LinkedQueue() {
        data = new DoublyLinkedList<T>();
    }

    @Override
    public void enqueue(T value) {
        if (isFull())
            throw new IndexOutOfBoundsException("is full");
        data.addLast(value);
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        return data.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public String summary() { return data.summary(); }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();

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

        //queue.enqueue(4);
        //queue.enqueue(5);

        queue.clear();
        queue.print();


        final int length = 3_000_000; // 500_000_000;
        final int popped = 1_000_000;

        Queue<Integer> linearStack = new LinearQueue<>(length);
        check(
                () -> IntStream.range(0, length).forEach(linearStack::enqueue)
        );

        linearStack.printSummary();

        Queue<Integer> linkedStack = new LinkedQueue<>();
        check(
                () -> IntStream.range(0, length).forEach(linkedStack::enqueue)
        );

        linkedStack.printSummary();


        check(
                () -> IntStream.range(0, popped).forEach(x -> linearStack.dequeue())
        );
        linearStack.printSummary();

        check(
                () -> IntStream.range(0, popped).forEach(x -> linkedStack.dequeue())
        );
        linkedStack.printSummary();


    }
}
