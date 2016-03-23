package Tree.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int maxDepth(TreeNode root) {
        return height(root);

    }

    public static int height(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return 1+ Math.max(height(treeNode.left),height(treeNode.right));
    }

    public static int maxDepthIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i=0; i<c; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth ++;
        }
        return depth;
    }
}
