package Amzon;

public class IsSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        protected TreeNode(int x) { val = x; }
    }
    //check if n2 is a subtree of n1
    public boolean isSubtree(TreeNode n1, TreeNode n2) {
        if (n2 == null) return true;
        if (n1 == null) return false;
        return isSameTree(n1, n2) || isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
    }

    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }

// 返回 int 类型
    public int isSubtree2(TreeNode n1, TreeNode n2) {
        if (n2 == null) return 1;
        if (n1 == null) return -1;
        if (isSameTree2(n1, n2) ==1  || isSubtree2(n1.left, n2) == 1 || isSubtree2(n1.right, n2) == 1) return 1;
        return -1;
    }

    public int isSameTree2(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return 1;
        if (n1 == null || n2 == null) return -1;
        if (n1.val == n2.val && isSameTree2(n1.left, n2.left) == 1 && isSameTree2(n1.right, n2.right)==1) return 1;
        return -1;
    }
}
