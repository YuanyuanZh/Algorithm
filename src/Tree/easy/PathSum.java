package Tree.easy;


import java.util.Stack;

public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        protected TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> path = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();
        path.push(root);
        sums.push(root.val);
        while (!path.isEmpty()) {
            TreeNode cur = path.pop();
            int curSum = sums.pop();
            if (cur.left == null && cur.right == null && curSum == sum) return true;
            if (cur.left != null) {
                path.push(cur.left);
                sums.push(curSum+cur.left.val);
            }
            if (cur.right != null) {
                path.push(cur.right);
                sums.push(curSum+cur.right.val);
            }
        }
        return false;
    }
}
