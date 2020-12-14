package live_study_05.option;

public class Solution {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(10);
        binaryTree.insert(9);
        binaryTree.inOrderTraverse(binaryTree.root);
        System.out.println();
        binaryTree.postOrderTraverse(binaryTree.root);
        System.out.println();
        binaryTree.preOrderTraverse(binaryTree.root);
    }
}
