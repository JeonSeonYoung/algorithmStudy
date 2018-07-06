package binary_tree;

public class App {

    public static void main(String[] args){

//        MyBinaryTree myBinaryTree = new MyBinaryTree();
//        myBinaryTree.put('G');
//        myBinaryTree.put('I');
//        myBinaryTree.put('H');
//        myBinaryTree.put('D');
//        myBinaryTree.put('B');
//        myBinaryTree.put('T');
//        myBinaryTree.put('K');
//        myBinaryTree.printBTS();
//        myBinaryTree.remove('I');

        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        myBinarySearchTree.put('G');
        myBinarySearchTree.put('I');
        myBinarySearchTree.put('H');
        myBinarySearchTree.put('D');
        myBinarySearchTree.put('B');
        myBinarySearchTree.put('T');
        myBinarySearchTree.put('K');
        myBinarySearchTree.remove('I');
        char parentData = myBinarySearchTree.getParentData('H');
        System.out.println(parentData);
        boolean containsData1 = myBinarySearchTree.contains('A');
        System.out.println(containsData1);
        boolean containsData2 = myBinarySearchTree.contains('D');
        System.out.println(containsData2);
    }
}
