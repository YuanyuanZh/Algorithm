package Tree.easy;


import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        protected TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int c  = queue.size();
            for (int i = 0; i< c; i++) {
                TreeNode cur = queue.poll();
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

        }
        return root;
    }

}
