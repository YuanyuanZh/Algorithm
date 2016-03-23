package Tree;


import java.util.Stack;

public class ConstructBinaryTreFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        stack.push(root);
        TreeNode node = null;
        TreeNode cur;
        int i = 0;
        int j = 0;
        while (j < inorder.length) {
            if (stack.peek().val == inorder[j]) {
                node = stack.pop();
                j++;
            }
            else if (node != null) {
                cur = new TreeNode(stack.pop().val);
                node.right = cur;
                node = null;
                stack.push(cur);
                i++;
            }
            else {
                cur = new TreeNode(preorder[i]);
                stack.peek().left =  cur;
                stack.push(cur);
                i++;
            }
        }
        return root.left;
    }

    public TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int ps, int[] inorder, int is, int ie) {
        if (ps > preorder.length - 1 || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int index = 0;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = build(preorder, ps + 1, inorder, is, index - 1);
        root.right = build(preorder, ps + index - is + 1, inorder, index + 1, ie);
        return root;
    }
}
