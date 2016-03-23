package Tree;


import java.util.Deque;
import java.util.LinkedList;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if ( len == 0 ) { return null; }

        // 0 as a placeholder
        TreeNode head = new TreeNode(0);

        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>();
        nodeStack.push(head);
        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>();
        leftIndexStack.push(0);
        Deque<Integer> rightIndexStack = new LinkedList<Integer>();
        rightIndexStack.push(len-1);

        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }

    public TreeNode sortedArrayToBSTRecursive(int[] nums) {
        if (nums == null || nums.length ==0 ) return null;
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r-l)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, l, mid - 1);
        node.right = helper(nums, mid + 1, r);
        return node;
    }
}
