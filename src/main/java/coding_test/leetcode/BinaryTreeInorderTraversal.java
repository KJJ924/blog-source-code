package coding_test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/30
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inOrder(root, ret);
        return ret;


    }

    public void inOrder(TreeNode treeNode, List<Integer> ret) {
        if (treeNode != null) {
            inOrder(treeNode.left, ret);
            ret.add(treeNode.val);
            inOrder(treeNode.right, ret);
        }
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
