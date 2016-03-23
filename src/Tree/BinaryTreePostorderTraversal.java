package Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) return rst;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }
            else {
                rst.add(cur.val);
            }
            pre = cur;
            stack.pop();
            cur = null;
        }
        return rst;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        helper(rst,root);
        return rst;
    }

    public void helper (List<Integer> rst, TreeNode node) {
        if (node == null) return;
        helper(rst, node.left);
        helper(rst, node.right);
        rst.add(node.val);
    }
}
