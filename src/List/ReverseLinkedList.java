package List;


public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
     public ListNode reverseListIterative(ListNode head) {
         ListNode pre = null;
         while (head != null) {
             ListNode tmp = head.next;
             head.next = pre;
             pre = head;
             head = tmp;
         }
         return pre;
     }

    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }
    public ListNode reverseList(ListNode head, ListNode node) {
        if (head == null) return node;
        ListNode next = head.next;
        head.next = node;
        return reverseList(next, head);
    }
}
