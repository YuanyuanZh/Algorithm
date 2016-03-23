package List;

//Sort a linked list in O(n log n) time using constant space complexity.
public class SortListNlogN {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        return merge2Lists(left,right);
    }

    private static ListNode merge2Lists(ListNode left, ListNode right) {
        ListNode rst = new ListNode(0);
        ListNode newHead = rst;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                newHead.next = left;
                left = left.next;
            }
            else {
                newHead.next = right;
                right = right.next;
            }
            newHead = newHead.next;
        }
        if (left != null) newHead.next = left;
        if (right != null) newHead.next = right;
        return rst.next;
    }
}
