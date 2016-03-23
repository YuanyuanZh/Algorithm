package Tree;


import java.util.Collections;
import java.util.Stack;

public class ValidateBinarySearchTree {

//    Assume a BST is defined as follows:
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val <= pre.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }


    public boolean isValidBSTRecursive(TreeNode root) {
        return isValidBST(root, (long)Integer.MIN_VALUE, (long)Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) return true;
        long val = root.val;
        return (val >= min && val <= max && isValidBST(root.left, min, val -1) && isValidBST(root.right, val+1, max));
    }
}
