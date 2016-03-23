package Tree.easy;


import java.util.Stack;

public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        protected TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        stackP.add(p);
        stackQ.add(q);
        while ((!stackP.isEmpty()) && (!stackQ.isEmpty())) {
            TreeNode pt = stackP.pop();
            TreeNode qt = stackQ.pop();
            if (pt.val != qt.val) return false;
            if (pt.left != null && qt.left != null) {
                stackP.push(pt.left);
                stackQ.push(qt.left);
            } else if (pt.left == null && qt.left == null) {
            } else {
                return false;
            }
            if (pt.right != null && qt.right != null) {
                stackP.push(pt.right);
                stackQ.push(qt.right);
            } else if (pt.right == null && qt.right == null) {
            } else {
                return false;
            }
        }
        return stackP.isEmpty() && stackQ.isEmpty();
    }
}
