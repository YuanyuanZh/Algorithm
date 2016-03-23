package Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

public class UniqueBinarySearchTreesII_DP {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<TreeNode> generateTree(int n) {
        List<TreeNode>[] rst = new List[n+1];
        rst[0] = new ArrayList<TreeNode>();
        rst[0].add(null);

        for (int len = 1; len <= n; len++) {
            rst[len] = new ArrayList<TreeNode>();
            for (int rootValue = 1; rootValue <= len; rootValue++) {
                for (TreeNode nodeL : rst[rootValue]) {
                    for (TreeNode nodeR : rst[len-rootValue]) {
                        TreeNode node = new TreeNode((rootValue));
                        node.left = nodeL;
                        node.right = clone(nodeR, rootValue);
                        rst[len].add(node);
                    }
                }
            }
        }
        return rst[n];
    }

    private static TreeNode clone(TreeNode n, int offset){
        if(n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
