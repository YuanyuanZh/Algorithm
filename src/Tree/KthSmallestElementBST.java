package Tree;


import java.util.Stack;

public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int c = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            c ++;
            if (c == k) return cur.val;
            cur = cur.right;
        }
        return -1;
    }

    public int kthSmallestRecursive(TreeNode root, int k) {
        int count = 0;
        int result = Integer.MIN_VALUE;
        traverse(result,count,root, k);
        return result;
    }

    public void traverse(int result,int count,TreeNode root, int k) {
        if(root == null) return;
        traverse(result,count,root.left, k);
        count ++;
        if(count == k) result = root.val;
        traverse(result,count,root.right, k);
    }

    public int kthSmallestBinarySearch(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
