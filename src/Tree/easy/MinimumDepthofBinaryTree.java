package Tree.easy;


import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        return height(root);
    }

    public int height(TreeNode treeNode) {
        if (treeNode == null) return 0;
        if (treeNode.left == null && treeNode.right == null) return 1;
        if (treeNode.left == null) return 1 + height(treeNode.right);
        if (treeNode.right == null) return 1+ height(treeNode.left);
        return 1+ Math.min(height(treeNode.left),height(treeNode.right));
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int c = queue.size();
            depth ++;
            for (int i = 0; i<c; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left == null && tmp.right == null) return depth;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);

            }
        }
        return depth;
    }
}
