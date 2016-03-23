package Tree;


import java.util.*;

public class PathSumII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        protected TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSumIterative(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) return rst;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> path = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        int target = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                path.add(cur.val);
                target += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }
            if (cur.left == null && cur.right == null && target == sum) {
                rst.add(new ArrayList<Integer>(path));
            }
            pre = cur;
            stack.pop();
            path.remove(path.size() - 1);
            target -= cur.val;
            cur = null;StringBuilder sb = new StringBuilder();
        }
        return rst;
    }

    public List<List<Integer>> pathSumRecursive(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) return rst;
        List<Integer> sub = new ArrayList<Integer>();
        dfs(rst, sub, root, sum);
        return rst;
    }

    public void dfs(List<List<Integer>> rst, List<Integer> sub, TreeNode root, int sum) {
        if (root == null) return;
        sub.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                rst.add(new ArrayList<Integer>(sub));
            return;
        }
        if (root.left != null) {
            dfs(rst, sub, root.left, sum - root.val);
            sub.remove(sub.size() - 1);
        }
        if (root.right != null) {
            dfs(rst, sub, root.right, sum - root.val);
            sub.remove(sub.size() - 1); // 往回走
        }
    }
}
