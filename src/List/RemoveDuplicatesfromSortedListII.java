package List;

//Given 1->1->1->2->3, return 2->3.
//Given 1->1->2->2, return []

public class RemoveDuplicatesfromSortedListII {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val != cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }
        }
        return newHead.next;
    }
}
