package Tree;

//LC95
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII_recursive {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s ; i <= e; i++) {
            List<TreeNode> leftSubTree = generateSubtrees(s,i);
            List<TreeNode> rightSubTree = generateSubtrees(i+1, e);
            for (TreeNode treeNodeL : leftSubTree) {
                for (TreeNode treeNodeR : rightSubTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = treeNodeL;
                    root.right = treeNodeR;
                    res.add(root);
                }
            }
        }
        return res;
    }
    public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for (int i:nums) {
            if (hm.containsKey(i)) {
                int t = hm.get(i);
                if (t > len/2) return i;
            }
            else {
                hm.put(i,1);
            }
        }
        return 0;
    }
}
