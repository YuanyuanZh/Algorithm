package Amzon;


public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        while (a.next != null) {
            a = a.next;
        }
        a.next = headB;
        ListNode slow = headA;
        ListNode fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = headA;
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

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
//        ListNode t = new ListNode(2);
//        a.next = t;
        ListNode b = a;
//        b.next = t;
        System.out.println(getIntersectionNode(a,b).val);
    }
}
