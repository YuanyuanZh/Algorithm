package Tree;


public class RecoverBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        traversal(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void traversal(TreeNode node) {
        if (node == null)
            return;
        traversal(node.left);
        if (first == null && pre.val >= node.val) {
            first = pre;
        }
        if (first != null && pre.val >= node.val) {
            second = node;
        }
        pre = node;
        traversal(node.right);
    }
}
