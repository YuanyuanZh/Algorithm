package Tree.easy;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        protected TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> binaryTreePathsRecursive(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        dfs(root, new ArrayList<Integer>(), rst);
        return rst;
    }

    public static void dfs(TreeNode node, List<Integer> sub, List<List<Integer>> rst) {
        if (node == null) return;
        sub.add(node.val);
        if (node.left == null && node.right == null) rst.add(new ArrayList<Integer>(sub));
        if (node.left != null) {
            dfs(node.left,sub,rst);
            sub.remove(sub.size()-1);
        }
        if (node.right != null) {
            dfs(node.right,sub,rst);
            sub.remove(sub.size()-1);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if (root == null) return rst;
        Stack<TreeNode> paths = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !paths.isEmpty()) {
            while (cur != null) {
                paths.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            cur = paths.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            } else if (cur.left == null && cur.right == null) {
                String s = "";
                for (int i : list) {
                    s += i;
                    s += "->";
                }
                rst.add(s.substring(0, s.length() - 2));
            }
            pre = cur;
            paths.pop();
            cur = null;

            list.remove(list.size() - 1);
        }
        return rst;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node5.left = node5.right = null;
        node4.left = node4.right = null;
        node2.left = node4;
        node2.right = node5;
        node3.left = node3.right = null;

        node1.left = node2;
        node1.right = node3;
        System.out.println(binaryTreePaths(node1));
        System.out.println(binaryTreePathsRecursive(node1));
    }
}
