package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/27
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode pointer = null;

        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                if(result == null){
                    result = l1;
                    pointer = l1;
                    l1 = l1.next;
                }else {
                    pointer.next = l1;
                    pointer = l1;
                    l1 = l1.next;
                }
            } else {
                if(result == null){
                    result = l2;
                    pointer = l2;
                    l2 = l2.next;
                }else {
                    pointer.next = l2;
                    pointer = l2;
                    l2 = l2.next;
                }
            }
        }
        return result;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
