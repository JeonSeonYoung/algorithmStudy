package algorithm.study.linkedlist;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

import static algorithm.study.util.LapUtil.check;

public class DoublyLinkedList<T> implements LinkedList<T> {

    class Node {

        private T value;
        private Node prev;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node node) {
            this.value = node.value;
            this.next = node.next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getPrev() { return prev; }

        public void setPrev(Node prev) { this.prev = prev; }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrev() {
            return prev != null;
        }

        @Override
        public String toString() {
            return String.format("[val : %s, prev : %s, next : %s]",
                    value,
                    hasPrev()? getPrev().getValue() : "null",
                    hasNext()? getNext().getValue() : "null"
            );
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void addFirst(T value) {
        if (isEmpty())
            head = tail = new Node(value);
        else {
            Node first = new Node(value, head);
            first.setNext(head);
            head.setPrev(first);
            head = first;
        }
        size++;
    }


    @Override
    public void addLast(T value) {
        if (isEmpty())
            head = tail = new Node(value);
        else {
            Node newLast = new Node(value);
            Node last = tail;
            last.setNext(newLast);
            newLast.setPrev(last);
            tail = newLast;
        }
        size++;
    }

    @Override
    public void add(int index, T value) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        if (size <= index)
            throw new IndexOutOfBoundsException(index + "");

        if(index == 0) {
            addFirst(value);
            return;
        }

        Node before = moveTo(index - 1);
        Node after = moveTo(index);

        Node add = new Node(value, after);
        before.setNext(add);
        add.setPrev(before);
        after.setPrev(add);

        size++;
    }

    private Node moveTo(int index) {
        boolean reverse = index > (size() / 2);
        Node iter = reverse? tail : head;
        int moves = reverse? size() - 1 - index : index;

        for (int i = 0; i < moves; i++) {
            iter = reverse? iter.getPrev() : iter.getNext();
        }
        return iter;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        T value = head.getValue();
        head = head.getNext();
        head.setPrev(null);

        size--;

        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        Node frontOfLast = moveTo(size - 2);

        T value = frontOfLast.getNext().getValue();
        frontOfLast.setNext(null);
        tail = frontOfLast;

        size--;

        return value;
    }

    @Override
    public T getFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        return head.getValue();
    }

    @Override
    public T remove(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        if (size <= index)
            throw new IndexOutOfBoundsException(index + "");

        if(index == 0)
            return removeFirst();

        if(index == size - 1)
            return removeLast();

        Node before = moveTo(index - 1);
        Node after = moveTo(index);

        T value = after.getValue();

        before.setNext(after.getNext());
        if(after.getNext() != null)
            after.getNext().setPrev(before);

        size--;

        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if(size() == 0)
            return;
        Node iter = tail;
        while (iter.hasPrev()) {
            iter.setNext(null);
            iter = iter.getPrev();
            iter.getNext().setPrev(null);
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int indexOf(T value) {
        Node iter = head;
        int index = 0;
        while (iter != null) {
            if (value.equals(iter.getValue()))
                return index;
            iter = iter.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public String toString() {
        String result = "";
        if (head != null) {
            Node iter = head;
            result = iter.getValue() + "";
            while (iter.hasNext()) {
                iter = iter.getNext();
                result += ", " + iter.getValue();
            }
        }
        return "[" + result + "], size : " + this.size();
    }

    @Override
    public String summary() {
        return String.format(
                "size : %s, head : %s, tail : %s",
                size(),
                !isEmpty()? head.getValue() : "null",
                !isEmpty()? tail.getValue() : "null"
        );
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        private Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T value = cursor.getValue();
            cursor = cursor.getNext();
            return value;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        linkedList.print(); // [3, 2, 1], size : 3

        linkedList.addLast(4);
        linkedList.addLast(5);

        linkedList.print(); // [3, 2, 1, 4, 5], size : 5

        linkedList.add(2, 7);
        linkedList.print(); // [3, 2, 7, 1, 4, 5], size : 6
        linkedList.add(5, 8);
        linkedList.print(); // [3, 2, 7, 1, 4, 8, 5], size : 7

        System.out.println(linkedList.removeFirst()); // 3
        linkedList.print(); // [2, 7, 1, 4, 8, 5], size : 6
        System.out.println(linkedList.removeFirst()); // 2
        linkedList.print(); // [7, 1, 4, 8, 5], size : 5
        System.out.println(linkedList.removeLast()); // 5
        linkedList.print(); // [7, 1, 4, 8], size : 4


        System.out.println(linkedList.remove(2)); // 4
        linkedList.print(); // [7, 1, 8], size : 3

        // iterator
        for (int x : linkedList) {
            System.out.print(x + " ");
        }
        System.out.println(""); // 7 1 8

        System.out.println(linkedList.remove(0)); // 7
        linkedList.print(); // [1, 8], size : 2
        System.out.println(linkedList.remove(1)); // 8
        linkedList.print(); // [1], size : 1

        linkedList.addFirst(9);
        linkedList.addLast(10);
        linkedList.add(0, 11);
        linkedList.print(); // [11, 9, 1, 10], size : 4


        System.out.println(linkedList.contains(9)); // T
        System.out.println(linkedList.contains(4)); // F
        System.out.println(linkedList.contains(1)); // T

        System.out.println(linkedList.indexOf(11)); // 0
        System.out.println(linkedList.indexOf(5)); // -1
        System.out.println(linkedList.indexOf(10)); // 3

        // for testing performance
        LinkedList<Integer> singly = new SinglyLinkedList<>();
        LinkedList<Integer> doubly = new DoublyLinkedList<>();
        int length = 50_000;
        int popped = 1_000;
        Random random = new Random();

        IntStream.range(1, length)
                .map(x -> random.nextInt(length))
                .forEach(singly::addLast);

        IntStream.range(1, length)
                .map(x -> random.nextInt(length))
                .forEach(doubly::addLast);


        check(
                () -> IntStream.range(1, popped)
                        .forEach(x -> singly.removeLast())
        );
        singly.printSummary();

        check(
                () -> IntStream.range(1, popped)
                        .forEach(x -> doubly.removeLast())
        );
        doubly.printSummary();


        check(
                () -> IntStream.range(40_000, 40_000 + popped)
                        .forEach(x -> singly.remove(x))
        );
        singly.printSummary();

        check(
                () -> IntStream.range(40_000, 40_000 + popped)
                        .forEach(x -> doubly.remove(x))
        );
        doubly.printSummary();

    }


}
