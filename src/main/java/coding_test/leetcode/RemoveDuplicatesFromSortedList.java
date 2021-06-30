package coding_test.leetcode;

import coding_test.leetcode.MergeTwoSortedLists.ListNode;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/30
 */
public class RemoveDuplicatesFromSortedList {


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
                cur = prev;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
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
