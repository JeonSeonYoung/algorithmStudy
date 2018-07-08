package algorithm.study.tree.binarytree;

import java.util.Optional;

public interface BinaryTree<T> {
    void put(T value);
    boolean contains(T value);
    Optional<T> getParentValueOf(T value);
    boolean removeSubtreeFor(T value);

    void remove(T value);
    BinarySearchTree.TraversedPath traverse(BinarySearchTree.TraverseOrder order);

    void print();
}
