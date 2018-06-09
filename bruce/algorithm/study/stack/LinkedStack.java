package algorithm.study.stack;

import algorithm.study.linkedlist.LinkedList;
import algorithm.study.linkedlist.SinglyLinkedList;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static algorithm.study.util.LapUtil.check;

public class LinkedStack<T> implements Stack<T> {

    private LinkedList<T> data;

    public LinkedStack() {
        data = new SinglyLinkedList<>();
    }

    public void push(T value) {
        data.addFirst(value);
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        return data.removeFirst();
    }

    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");
        return data.getFirst();
    }

    public long size() {
        return data.size();
    }

    public void clear() {
        data.clear();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public String summary() { return data.summary(); }

    // test client
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();

        stack.print();
        IntStream.range(0, 10).forEach(
                stack::push
        );

        stack.print();

        IntStream.range(0, 3).forEach(
                i -> System.out.println(stack.pop())
        );

        stack.print();

        IntStream.range(0, 2).forEach(
                stack::push
        );

        stack.print();


        final int length = 3_000_000; // 500_000_000;
        final int popped = 1_000_000;

        Stack<Integer> linearStack = new LinearStack<>(length);
        check(
                () -> IntStream.range(0, length).forEach(linearStack::push)
        );

        linearStack.printSummary();

        Stack<Integer> linkedStack = new LinkedStack<>();
        check(
                () -> IntStream.range(0, length).forEach(linkedStack::push)
        );

        linkedStack.printSummary();


        check(
                () -> IntStream.range(0, popped).forEach(x -> linearStack.pop())
        );
        linearStack.printSummary();

        check(
                () -> IntStream.range(0, popped).forEach(x -> linkedStack.pop())
        );
        linkedStack.printSummary();


    }
}
