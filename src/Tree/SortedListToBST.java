package Tree;


public class SortedListToBST {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }
    public TreeNode helper(ListNode start, ListNode end) {
        if (start == end) return null;
        ListNode slow = start;
        ListNode fast = start;
        while (fast.next != end ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = helper(start,slow);
        node.right = helper(slow.next, end);
        return node;
    }
}
