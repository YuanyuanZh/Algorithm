package Tree;

import java.util.Stack;

// find the next node of give node value in BST tree
// you don't need to consider the case which the node doesn't exist

public class FindNextBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            if (this.left != null) this.left.parent = this;
            if (this.right != null) this.right.parent = this;
        }
    }

    public static int findNextNode(TreeNode root, int target) {
        if (root == null) return -1;
        if (root.val > target) {
            return findNextNode(root.left, target);
        }
        else if(root.val < target) {
            return findNextNode(root.right, target);
        }
        else {
            TreeNode cur;
            if (root.right == null) {
                 cur = root.parent;
                while (cur != null && cur.val < target) {
                    cur = cur.parent;
                }
            }else {
                cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
            }
            return cur.val;
        }
    }

    public static int findNext2(TreeNode root, int target) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                if (cur.val == target) {
                    if (cur.right == null) {
                        return stack.pop().val;
                    }
                    else {
                        cur = cur.right;
                        while (cur.left != null) {
                            cur = cur.left;
                        }
                        return cur.val;
                    }
                }
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return -1;
    }

    public static int findNextNode3(TreeNode root, int target){
        TreeNode successor = null;
        while (root != null && root.val != target) {
            if (root.val > target) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return -1;
        }

        if (root.right == null) {
            return successor.val;
        }

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7,null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node13 = new TreeNode(13, null, null);
        TreeNode node6 = new TreeNode(6, null, node7);
        TreeNode node4 = new TreeNode(4,node3, node6);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node11 = new TreeNode(11, null, node13);
        TreeNode node10 = new TreeNode(10,node9,node11);
        TreeNode node8 = new TreeNode(8,node4, node10);
        System.out.println(findNextNode(node8,9));
        System.out.println(findNextNode(node8,8));
        System.out.println(findNextNode3(node8,8));
    }
}
