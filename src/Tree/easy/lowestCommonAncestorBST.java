package Tree.easy;


import Tree.TreeNode;

public class lowestCommonAncestorBST extends TreeNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        protected TreeNode(int x) { val = x; }
    }

    lowestCommonAncestorBST(int x) {
        super(x);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if ( p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p,q);
        else if (p.val > root.val && q.val >root.val) return lowestCommonAncestor(root.right, p,q);
        else return root;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        while (root != null) {
            if ( p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if (p.val > root.val && q.val >root.val){
                root = root.right;
            }
            else
                return root;
        }
        return null;
    }

}
