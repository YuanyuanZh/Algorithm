package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            rst.add(cur.val);
            cur = cur.right;
        }
        return rst;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        helper(rst,root);
        return rst;
    }

    public void helper(List<Integer> rst,TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            helper(rst,root.left);
        }
        rst.add(root.val);
        if (root.right != null) {
            helper(rst, root.right);
        }
    }
}
