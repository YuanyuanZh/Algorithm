package List;


public class MergekSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKList(lists, 0, lists.length-1);
    }

    public static ListNode mergeKList(ListNode[] lists, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return lists[lo];
        int mid = (hi + lo)/2;
        ListNode left =  mergeKList(lists,lo, mid);
        ListNode right = mergeKList(lists,mid+1,hi);
        return merge2Lists(left, right);
    }

    private static ListNode merge2Lists(ListNode left, ListNode right) {
        ListNode newHead = new ListNode(0);
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
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node3.next = new ListNode(4);
        ListNode[] list = {node1,node3};
        System.out.println(mergeKLists(list));
    }
}
