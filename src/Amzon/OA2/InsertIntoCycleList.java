package Amzon.OA2;

//往已经排好序的循环列表里插入节点
public class InsertIntoCycleList {
    class CNode {
        public int val;
        public CNode next;

        CNode(int _val) {
            val = _val;
        }
    }

    public CNode Solution(CNode head, int target) {
        CNode newNode = new CNode(target);
        if (head == null) {
            newNode.next = newNode; // 不能忘
            return newNode;
        }
        CNode cur = head;
        do {
            if (target > cur.val && target <= cur.next.val) break;
            if (cur.val > cur.next.val && (target > cur.val || target <= cur.next.val)) break;//1->2->1 insert 0,1 or 3
            cur = cur.next;
        } while (cur != head);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }
    //  case 1 : pre.val ≤ x ≤ cur.val://插入元素刚好是中间大小
    //  Insert between pre and cur.
    //  case 2 : x is the maximum or minimum value in the list: 插入元素是最大或者最小值
    //  Insert before the head. e.g. the head has the smallest value
    //  and its pre.val > head.val.
    //  case 3 : Traverses back to the starting point:
    //  Insert before the starting point.
}
