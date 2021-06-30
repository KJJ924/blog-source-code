package coding_test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/30
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        preOrder(p, pList);
        List<Integer> qList = new ArrayList<>();
        preOrder(q, qList);

        if (pList.size() != qList.size()) {
            return false;
        }

        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).equals(qList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void preOrder(TreeNode node, List<Integer> ret) {
        if (node != null) {
            ret.add(node.val);
            preOrder(node.left, ret);
            preOrder(node.right, ret);
        } else {
            ret.add(0);
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
