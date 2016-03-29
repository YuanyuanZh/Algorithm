package List;


public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode buddy = head;
        ListNode reverseHead = buddy;
        int count = 1;
        while (buddy !=null && count < m) {
            reverseHead = buddy;
            buddy = buddy.next;
            count++;
        }
        count = 1;
        ListNode pre = buddy;
        ListNode tail = buddy;
        while (buddy != null && count <= (n-m+1)) {
            ListNode tmp = buddy.next;
            if (pre != buddy) buddy.next = pre;
            pre = buddy;
            buddy = tmp;
            count++;
        }
        reverseHead.next = pre;
        tail.next = buddy;
        return m == 1 ?pre : head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode rst = reverseBetween(node1,2,4);
        System.out.println(rst);
    }
}
