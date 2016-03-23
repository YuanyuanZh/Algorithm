package List;

// 1. find the mid node
// 2. reverse the list from mid node to tail, not including the mid node
// 3. compare the first half and the reversed second half, two cases are ok
//      - pairwise equal
//      - pairwise equal until the last pair of <midnode, null>

public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next!= null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode reversedHead = reverseList(mid.next);
        mid.next = null;
        while (head != null && reversedHead!= null) {
            if (head.val != reversedHead.val) return false;
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return head == null || head == mid;//even /old // 123321, 12321

    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(isPalindrome(node1));
    }
}
