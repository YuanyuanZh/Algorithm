package Tree.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        protected TreeNode(int x) {
            val = x;
        }
    }

    // O(N2)
    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left)
                && isBalanced(root.right));
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // O(N)
    public boolean isBalanced2(TreeNode root) {
        return root == null || dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(dfsHeight(root.left), dfsHeight(root.right)) + 1;
    }

}
