package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LowestCommonAncestorofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null;
        if(right == null) return left;
        if(left == null) return right;
        return root;

    }


    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = findPath(root,p);
        List<TreeNode> path2 = findPath(root,q);
        int shorter = path1.size() < path2.size()? path1.size():path2.size();
        for(int i = 0; i < shorter; i++) {
            if(path1.get(i) != path2.get(i)) {
                return path1.get(i-1);
            }
        }
        return  path1.size() < path2.size()? p:q;
    }
    public List<TreeNode> findPath(TreeNode root, TreeNode n){
        List<TreeNode> path = new ArrayList<TreeNode>();
        if (root == null) {
            return path;
        }
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || path.size() > 0) {
            while (cur != null) {
                path.add(cur);
                if (cur == n) {
                    return path;
                }
                cur = cur.left;
            }
            cur = path.get(path.size() - 1);
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }

            pre = cur;
            path.remove(path.size() - 1);
            cur = null;

        }
        return path;
    }

}
