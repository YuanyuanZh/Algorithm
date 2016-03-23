package Tree;


import java.util.Stack;

public class ConstructBinaryTreFromPostorderAndInorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int ps, int is, int ie) {
        if (is > ie || ps < 0) return null;
        TreeNode root = new TreeNode(postorder[ps]);
        int index = 0;
        for (int i = is; i < ie; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = build(inorder, postorder, ps - (ie - index + 1), is, index - 1);
        root.right = build(inorder, postorder, ps - 1, index + 1, ie);
        return root;
    }

    public TreeNode buildTreeIterative(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        stack.push(root);
        TreeNode cur;
        TreeNode node = null;
        int i = postorder.length - 1;
        int j = inorder.length - 1;
        while (i >= 0) {
            if (stack.peek().val == inorder[j]) {
                node = stack.pop();
                j--;
            } else if (node != null) {
                cur = new TreeNode(postorder[i]);
                node.left = cur;
                stack.push(cur);
                node = null;
                i--;
            } else {
                cur = new TreeNode(postorder[i]);
                stack.peek().right = cur;
                stack.push(cur);
                i--;
            }
        }
        return root.right;
    }
}
