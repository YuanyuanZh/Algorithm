package DP;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/discuss/91899/step-by-step-tackling-of-the-problem

public class HouseRobberIII {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        protected TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return robSub(root, map);
    }

    public int robSub(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);
        int val = 0;
        if (node.left != null) {
            val += robSub(node.left.left, map) + robSub(node.left.right, map);
        }
        if (node.right != null) {
            val += robSub(node.right.right, map) + robSub(node.left.right, map);
        }
        val = Math.max(val + node.val,robSub(node.left,map) + robSub(node.right, map));
        map.put(node, val);
        return val;
    }

    public int robDP(TreeNode root) {
        int[] res =robSub(root);
        return Math.max(res[0], res[2]);
    }

    public int[] robSub(TreeNode node) {
        if (node == null) return new int[2];
        int[] left = robSub(node.left);
        int[] right = robSub(node.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }
}
