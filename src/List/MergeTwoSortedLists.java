package List;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeTwoSortedLists {
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode rst = new ListNode(Integer.MIN_VALUE);
        ListNode newHead = rst;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            }
            else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        if (l1 != null) {
            newHead.next = l1;
        }
        if (l2 != null) {
            newHead.next = l2;
        }
        return rst.next;
    }
}
