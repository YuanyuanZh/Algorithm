package Amzon;


public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode MergeTwoSortedList(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        if (node1.val <= node2.val ) {
            node1.next = MergeTwoSortedList(node1.next, node2);
            return node1;
        }
        else {
            node2.next = MergeTwoSortedList(node1,node2.next);
            return node2;
        }
    }

    public static ListNode mergeIterative(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (node1 != null && node2 != null){
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            }
            else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) cur.next = node1;
        if (node2 != null) cur.next = node2;
        return head.next;
    }
}
