package Amzon.OA2;

// Given a tree of N nodes, return the amplitude of the tree.
// Amplitude 就是 从root到leaf，Max-Min的差~找所有路径，返回最大值.

public class AmplitudeOfTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        protected TreeNode(int x) {
            val = x;
        }
    }
    static int MAX = Integer.MIN_VALUE;
    public static int getAmplitudeOfTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root,root.val,root.val);
        return MAX;
    }

    public static void dfs (TreeNode node, int min, int max) {
        if (node == null) return;
        min = Math.min(min,node.val);
        max = Math.max(max,node.val);
        if (node.left == null && node.right == null){
            MAX = Math.max(MAX,max-min);
        }
        dfs(node.left,min,max);
        dfs(node.left,min,max);
    }

    public static int getAmplitude3(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root, root.val, root.val);
    }
    private static int helper(TreeNode root, int min, int max) {
        if (root == null)
            return max - min;
        if (root.val < min)
            min = root.val;
        if (root.val > max)
            max = root.val;
        return Math.max(helper(root.left, min, max), helper(root.right, min, max));
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        System.out.println(getAmplitudeOfTree(n1));
        System.out.println(getAmplitude3(n1));
    }
}

