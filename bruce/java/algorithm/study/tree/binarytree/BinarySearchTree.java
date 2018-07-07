package algorithm.study.tree.binarytree;

import algorithm.study.linkedlist.DoublyLinkedList;
import algorithm.study.linkedlist.LinkedList;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static algorithm.study.util.LapUtil.check;

// TODO : 중복 검사 처리
public class BinarySearchTree<T> implements BinaryTree<T> {
    private class Node {
        private T value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(T value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    @Override
    public void put(T value) {
        root = put(value, root, null);
    }

    private Node put(T value, Node node, Node parent) {
        if (node == null)
            node = new Node(value, parent);
        else if (isLessThan(node.value, value))
            node.left = put(value, node.left, node);
        else
            node.right = put(value, node.right, node);

        return node;
    }

    private boolean isLessThan(T lhs, T rhs) {
        if (lhs instanceof Integer)
            return Integer.compare((Integer) lhs, (Integer) rhs) > 0;

        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean contains(T value) {
        return find(value, root).isPresent();
    }

    private Optional<Node> find(T value, Node node) {
        if (node == null)
            return Optional.empty();
        if (value.equals(node.value))
            return Optional.of(node);
        else if (isLessThan(node.value, value))
            return find(value, node.left);
        else
            return find(value, node.right);
    }

    @Override
    public Optional<T> getParentValueOf(T value) {
        return find(value, root)
                .map(Node::getParent)
                .map(Node::getValue)
                .map(Optional::of)
                .orElse(Optional.empty());
    }

    @Override
    public boolean removeSubtreeFor(T value) {
        if (value.equals(root.value)) {
            clear();
            return true;
        }

        Optional<Node> foundOptional = find(value, root);
        if (!foundOptional.isPresent())
            return false;

        Node found = foundOptional.get();
        Node parent = found.getParent();

        found.setParent(null);
        if (isLessThan(parent.value, value))
            parent.setLeft(null);
        else parent.setRight(null);

        return true;
    }

    private void clear() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.put(1);
        tree.put(6);
        tree.put(3);
        tree.put(2);
        tree.put(4);
        /*
           1
               6
             3
           2   4
         */

        System.out.println(tree.contains(3));
        System.out.println(tree.contains(5));


        System.out.println(
                tree.getParentValueOf(2)
                        .map(Object::toString)
                        .orElse("none")
        );

        System.out.println(
                tree.getParentValueOf(1)
                        .map(Object::toString)
                        .orElse("none")
        );


        tree.removeSubtreeFor(3);


        System.out.println(tree.contains(3));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(1));

        tree.removeSubtreeFor(1); // clear

        final int length = 3_000_000; // 500_000_000;
        final int popped = 1_000;

        List<Integer> data = ThreadLocalRandom.current().ints(length, 0, length).boxed().collect(Collectors.toList());

        LinkedList<Integer> linkedList = new DoublyLinkedList<>();
        check(
                "linkedList::addFirst",
                () -> data.forEach(linkedList::addFirst)
        );
        check(
                "tree::put",
                () -> data.forEach(tree::put)
        );

        Collections.shuffle(data);

        List<Integer> picks = data.subList(0, popped);

        check(
                "linkedList::contains",
                () -> picks.forEach(linkedList::contains)
        );
        check(
                "tree::contains",
                () -> picks.forEach(tree::contains)
        );

    }
}
