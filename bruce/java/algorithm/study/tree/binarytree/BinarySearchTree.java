package algorithm.study.tree.binarytree;

import algorithm.study.linkedlist.DoublyLinkedList;
import algorithm.study.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static algorithm.study.util.LapUtil.check;

// TODO : 중복 검사 처리
public class BinarySearchTree<T extends Comparable<?>> implements BinaryTree<T> {

    enum TraverseOrder {
        PREORDER, INORDER, POSTORDER
    }

    class TraversedPath {
        List<Node> path = new ArrayList<>();

        public void add(Node node) {
            path.add(node);
        }

        @Override
        public String toString() {
            return path.stream()
                    .map(Node::getValue)
                    .map(Object::toString)
                    .collect(Collectors.joining(" -> "));
        }
    }

    class Node {
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

        public void setValue(T value) { this.value = value; }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean hasLeft() {
            return this.left != null;
        }

        public boolean hasRight() {
            return this.right != null;
        }

        public boolean hasBoth() {
            return hasLeft() && hasRight();
        }

        public boolean isLeaf() {
            return !hasLeft() && !hasRight();
        }
    }

    private Node root;

    @Override
    public void put(T value) {
        if(!contains(value))
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

    @Override
    public boolean remove(T value) {
        return remove(value, root);
    }

    private boolean remove(T value, Node node) {
        Optional<Node> foundOptional = find(value, node);
        if (!foundOptional.isPresent())
            return false;

        Node found = foundOptional.get();
        Node parent = found.getParent();
        if(found.isLeaf()) {
            found.setParent(null);
            if (isLessThan(parent.value, value))
                parent.setLeft(null);
            else parent.setRight(null);
        } else if(found.hasBoth()) { // http://www.algolist.net/Data_structures/Binary_search_tree/Removal
            // get right subtree
            Node rightSubtree = found.getRight();
            // get min val(left most) node of right subtree
            Node leftMost = rightSubtree;
            while(leftMost.getLeft() != null)
                leftMost = leftMost.getLeft();
            // set found node val as min val
            found.setValue(leftMost.getValue());
            // remove min val from right subtree
            remove(leftMost.getValue(), rightSubtree);
        } else if(found.hasLeft()) {
            Node candidate = found.getLeft();
            if (isLessThan(parent.value, value))
                parent.setLeft(candidate);
            else parent.setRight(candidate);
        } else if(found.hasRight()) {
            Node candidate = found.getRight();
            if (isLessThan(parent.value, value))
                parent.setLeft(candidate);
            else parent.setRight(candidate);
        }

        return true;
    }

    @Override
    public TraversedPath traverse(TraverseOrder order) {
        if (TraverseOrder.PREORDER.equals(order))
            return preorder(root, new TraversedPath());
        if (TraverseOrder.INORDER.equals(order))
            return inorder(root, new TraversedPath());
        if (TraverseOrder.POSTORDER.equals(order))
            return postorder(root, new TraversedPath());

        throw new RuntimeException("not implemented");
    }


    private TraversedPath preorder(Node node, TraversedPath currentPath) {
        if (node == null)
            return currentPath;
        currentPath.add(node);
        currentPath = preorder(node.left, currentPath);
        currentPath = preorder(node.right, currentPath);
        return currentPath;
    }

    private TraversedPath inorder(Node node, TraversedPath currentPath) {
        if (node == null)
            return currentPath;
        currentPath = inorder(node.left, currentPath);
        currentPath.add(node);
        currentPath = inorder(node.right, currentPath);
        return currentPath;
    }

    private TraversedPath postorder(Node node, TraversedPath currentPath) {
        if (node == null)
            return currentPath;
        currentPath = postorder(node.left, currentPath);
        currentPath = postorder(node.right, currentPath);
        currentPath.add(node);
        return currentPath;
    }

    private void clear() {
        root = null;
    }

    //@Override
    public void print() {
        BTreePrinter.printNode(root);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.put(1);
        tree.put(6);
        tree.put(3);
        tree.put(2);
        tree.put(4);
        tree.put(7);
        tree.put(-1);
        tree.put(-3);
        tree.put(0);
        tree.put(1); // duplicate

        tree.put(8);
        tree.print();
        tree.remove(8);
        tree.print();

        tree.put(8);
        tree.put(10);
        tree.print();
        tree.remove(8);
        tree.print();

        tree.remove(6);
        tree.print();

        System.out.println("PREORDER : " + tree.traverse(TraverseOrder.PREORDER));
        System.out.println("INORDER : " + tree.traverse(TraverseOrder.INORDER));
        System.out.println("POSTORDER : " + tree.traverse(TraverseOrder.POSTORDER));

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

// reference : https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(BinarySearchTree<T>.Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BinarySearchTree<T>.Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<BinarySearchTree<T>.Node> newNodes = new ArrayList<BinarySearchTree<T>.Node>();
        for (BinarySearchTree<T>.Node node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
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

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
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

    private static <T extends Comparable<?>> int maxLevel(BinarySearchTree<T>.Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.getLeft()), BTreePrinter.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}