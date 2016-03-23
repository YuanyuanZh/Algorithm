package Amzon.OA2;


import java.util.Stack;

public class minPathSum {
    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }
    public static int SolutionR(TreeNode root) {
        if (root == null)	return 0;
        if (root.left != null && root.right == null)
            return SolutionR(root.left) + root.val;
        if (root.left == null && root.right != null)
            return SolutionR(root.right) + root.val;
        return Math.min(SolutionR(root.left), SolutionR(root.right)) + root.val;
    }

    public static int Solution(TreeNode root) {
        if (root == null) return 0;
        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                sum += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.left == null && cur.right == null) {
                min = Math.min(min, sum);
            }
            if (cur.right != null && pre != cur.right){
                cur = cur.right;
                continue;
            }
            pre = cur;
            sum -= cur.val;
            stack.pop();
            cur = null;
        }
        return min;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(0);
        right.right = new TreeNode(6);
        root.left = left;
        root.right = right;
        System.out.println(Solution(root));
        System.out.println(SolutionR(root));
    }
}
