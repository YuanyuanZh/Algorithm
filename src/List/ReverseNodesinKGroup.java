package List;


public class ReverseNodesinKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = dummy;

        while (p != null) {
            pre = p;

            for (int i = 0; i <k ;i++) {
                p = p.next;
                if (p == null) return dummy.next;
            }
            p = reverseList(pre, p.next);
        }
        return dummy.next;
    }

    public ListNode reverseList (ListNode start, ListNode end) {
        ListNode p = start.next;
        while (p.next != end) {
            ListNode n = p.next;
            p.next = n.next;
            n.next = start.next;
            start.next = n;
        }
        return p;
    }
}
