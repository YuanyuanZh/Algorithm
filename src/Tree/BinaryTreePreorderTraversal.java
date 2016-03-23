package Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        helper(rst,root);
        return rst;
    }

    public void helper (List<Integer> rst,TreeNode node) {
        if (node == null) return;
        rst.add(node.val);
        helper(rst,node.left);
        helper(rst,node.right);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) return rst;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                rst.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return rst;
    }
}
