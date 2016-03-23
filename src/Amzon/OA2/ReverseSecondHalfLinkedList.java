package Amzon.OA2;


public class ReverseSecondHalfLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public static void reverse(ListNode head){
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next; // 这样写奇偶长度都能考虑到, 但前面要加corn case head.next == null
        while (fast.next != null && fast.next.next != null) { // 一定要这样
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        slow.next = pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        reverse(node);
        while (node != null) {
            System.out.println(node.val);
            node= node.next;
        }
    }

}
