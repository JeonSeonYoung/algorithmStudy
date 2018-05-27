package algorithm.study.linkedlist;

import java.util.Iterator;

public class SinglyLinkedList<T> implements LinkedList<T> {

    class Node {

        private T value;
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

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

    }

    private Node head;
    private int size = 0;

    @Override
    public void addFirst(T value) {
        if (isEmpty())
            head = new Node(value);
        else {
            Node first = new Node(value, head);
            head = first;
        }
        size++;
    }


    @Override
    public void addLast(T value) {
        if (isEmpty())
            head = new Node(value);
        else {
            Node newLast = new Node(value);
            Node last = head;
            while (last.hasNext()) last = last.getNext();
            last.setNext(newLast);
        }
        size++;
    }

    @Override
    public void add(int index, T value) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        if (size <= index)
            throw new IndexOutOfBoundsException(index + "");

        Node before = moveTo(index - 1);
        Node after = moveTo(index);

        Node add = new Node(value, after);
        before.setNext(add);

        size++;
    }

    private Node moveTo(int index) {
        Node iter = head;
        for (int i = 0; i < index; i++) {
            iter = iter.getNext();
        }
        return iter;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        T value = head.getValue();
        head = head.getNext();

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

        size--;

        return value;
    }

    @Override
    public T remove(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("is empty");

        if (size <= index)
            throw new IndexOutOfBoundsException(index + "");

        Node before = moveTo(index - 1);
        Node after = moveTo(index);

        T value = after.getValue();

        before.setNext(after.getNext());

        size--;

        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
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
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
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

        linkedList.addFirst(9);
        linkedList.addLast(10);
        linkedList.add(3, 11);
        linkedList.print(); // [9, 7, 1, 11, 8, 10], size : 6


        System.out.println(linkedList.contains(9)); // T
        System.out.println(linkedList.contains(4)); // F
        System.out.println(linkedList.contains(1)); // T

        System.out.println(linkedList.indexOf(11)); // 3
        System.out.println(linkedList.indexOf(5)); // -1
        System.out.println(linkedList.indexOf(10)); // 5

    }
}
