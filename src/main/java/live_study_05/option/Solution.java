package live_study_05.option;

import java.util.List;

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

        List<Integer> preOrderTraverse = binaryTree.Traverse(binaryTree.root, BinaryTree.PRE_ORDER_TRAVERSE);
        System.out.println(preOrderTraverse);

        List<Integer> inOrderTraverse = binaryTree.Traverse(binaryTree.root,BinaryTree.IN_ORDER_TRAVERSE);
        System.out.println(inOrderTraverse);

        List<Integer> postOrderTraverse = binaryTree.Traverse(binaryTree.root,BinaryTree.POST_ORDER_TRAVERSE);
        System.out.println(postOrderTraverse);

        List<Integer> bfs = binaryTree.BFS(binaryTree.root);
        System.out.println(bfs);
    }
}
