package List;


public class IntersectionofTwoLinkedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        if (headA.next == null || headB.next == null) return headA == headB ? headA : null;
        ListNode a = headA;
        while (a.next != null) {
            a = a.next;
        }
        a.next = headB;
        ListNode slow = headA;
        ListNode fast = headA;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                a.next = null;
                return slow;
            }
        }
        a.next = null;
        return null;
    }

}
