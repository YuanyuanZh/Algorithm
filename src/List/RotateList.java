package List;


public class RotateList {

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 ) return head;
        ListNode node = head;
//        ListNode pre = head;
        int len = 1;
        while (node.next != null) {
//            pre = node;
            len ++;
            node = node.next;
        }
        k = k % len;
        int c = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode  cur = head;

        while (cur != null && c < len - k) {
            cur = cur.next;
            c++;
        }
        node.next = dummy.next;
        dummy.next = cur.next;
        cur.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        ListNode rst = rotateRight(node1,1);
        System.out.println(rst);
    }
}
