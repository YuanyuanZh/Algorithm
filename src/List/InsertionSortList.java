package List;


public class InsertionSortList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        ListNode pre ;
        ListNode cur = head;
        while (cur != null) {
            pre = newHead;
            while (pre.next != null && pre.next.val <= cur.val) {
                pre = pre.next;
            }
            ListNode n = pre.next;
            pre.next = cur;
            cur = cur.next;
            pre.next.next = n;

        }
        return  newHead.next;
    }
}
