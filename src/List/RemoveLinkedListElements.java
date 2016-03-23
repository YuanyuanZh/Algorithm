package List;

public class RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val) pointer.next = pointer.next.next;
            else pointer = pointer.next;
        }
        return head.val == val ? head.next : head;

        // while(head != null && head.val == val) {
        //     head = head.next;
        // }
        // if(head == null) {
        //     return head;
        // }
        // ListNode p = head;
        // while(p.next != null) {
        //     if(p.next.val == val) {
        //         p.next = p.next.next;
        //     } else {
        //         p = p.next;
        //     }
        // }
        // return head;
    }
}
