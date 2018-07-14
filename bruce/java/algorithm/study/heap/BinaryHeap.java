package algorithm.study.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {

    enum Type {
        MAX, MIN
    }

    private static int ROOT_INDEX = 1;

    private T[] binaryTree;
    private Type type;
    private int level;
    private int maxSize;
    private int lastIndex;

    public BinaryHeap(int level, Type type) {
        this.level = level;
        this.maxSize = (int) Math.pow((double) 2, (double) level);
        this.type = type;
        this.binaryTree = (T[]) new Comparable[maxSize];
        lastIndex = ROOT_INDEX - 1;
    }

    @Override
    public void put(T value) {
        if(isFull())
            throw new ArrayIndexOutOfBoundsException("is full");
        // TODO : choose next index if binaryTree[parent(lastIndex)] is equal to value
        binaryTree[++lastIndex] = value;
        upHeap(value);
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new ArrayIndexOutOfBoundsException("is empty");
        T value = binaryTree[ROOT_INDEX];
        binaryTree[ROOT_INDEX] = binaryTree[lastIndex--];
        maxHeapify();
        return value;
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public int level() {
        return level;
    }

    @Override
    public void print() {
        BTreePrinter.printNode(binaryTree, ROOT_INDEX, lastIndex);
    }

    private boolean isFull() {
        return size() >= maxSize;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    // https://ko.wikipedia.org/wiki/%ED%9E%99_(%EC%9E%90%EB%A3%8C_%EA%B5%AC%EC%A1%B0)
    private void upHeap(T value) {
        T val = value;
        int foundIdx = lastIndex;
        int parentIdx = getParent(foundIdx);
        while (foundIdx > ROOT_INDEX &&
                !val.equals(binaryTree[ROOT_INDEX]) &&
                compare(binaryTree[parentIdx], binaryTree[foundIdx])
                ) {
            swap(parentIdx, foundIdx);
            val = binaryTree[parentIdx];

            foundIdx = parentIdx;
            parentIdx = getParent(foundIdx);
        }
    }

    private void maxHeapify() {
        maxHeapify(ROOT_INDEX);
    }

    // https://en.wikipedia.org/wiki/Binary_heap
    private void maxHeapify(int index) {
        int left = index * 2;
        int right = index * 2 + 1;
        int largest = index;
        if (left <= lastIndex && compare(binaryTree[largest], binaryTree[left]))
            largest = left;
        if (right <= lastIndex && compare(binaryTree[largest], binaryTree[right]))
            largest = right;

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int left, int right) {
        T temp = binaryTree[left];
        binaryTree[left] = binaryTree[right];
        binaryTree[right] = temp;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private boolean compare(T lhs, T rhs) {
        return type.equals(Type.MIN) ?
                lhs.compareTo(rhs) > 0 : lhs.compareTo(rhs) < 0;
    }

    public static void main(String[] args) {
        Heap<Integer> maxHeap = new BinaryHeap<>(10, Type.MAX);

        maxHeap.put(1);
        maxHeap.print();
        maxHeap.put(5);
        maxHeap.print();
        maxHeap.put(4);
        maxHeap.print();
        maxHeap.put(7);
        maxHeap.print();
        maxHeap.put(6);
        maxHeap.print();
        maxHeap.put(8);
        maxHeap.print();
        maxHeap.put(9);
        maxHeap.print();
        maxHeap.put(2);
        maxHeap.print();

        System.out.println(maxHeap.pop());
        maxHeap.print();
        System.out.println(maxHeap.pop());
        maxHeap.print();
        System.out.println(maxHeap.pop());
        maxHeap.print();


        Heap<Integer> minHeap = new BinaryHeap<>(10, Type.MIN);

        minHeap.put(1);
        minHeap.print();
        minHeap.put(5);
        minHeap.print();
        minHeap.put(4);
        minHeap.print();
        minHeap.put(7);
        minHeap.print();
        minHeap.put(6);
        minHeap.print();
        minHeap.put(8);
        minHeap.print();
        minHeap.put(9);
        minHeap.print();
        minHeap.put(2);
        minHeap.print();

        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();

    }
}

class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}

// reference : https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(T[] binaryTree, int rootIndex, int lastIndex) {
        Node<T> root = new Node(binaryTree[rootIndex]);
        Node<T>[] mapping = new Node[lastIndex + 1];
        mapping[rootIndex] = root;
        for (int i = rootIndex + 1; i <= lastIndex; i++) {
            T value = binaryTree[i];
            mapping[i] = new Node<>(value);
        }

        for (int i = lastIndex; i > rootIndex; i--) {
            int parent = i / 2;
            if (parent < rootIndex) break;
            mapping[parent].setLeft(mapping[parent * 2]);
            if (parent * 2 + 1 > lastIndex) continue;
            mapping[parent].setRight(mapping[parent * 2 + 1]);
        }

        printNode(root);
    }

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}