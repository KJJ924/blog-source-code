package coding_test.leetcode;

import coding_test.leetcode.BinaryTreeInorderTraversal.TreeNode;

/**
 * @author dkansk924@naver.com
 * @since 2021/07/01
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return preOrder(root, 0);

    }

    public int preOrder(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        return Math.max(preOrder(root.left, depth + 1), preOrder(root.right, depth + 1));
    }

}
