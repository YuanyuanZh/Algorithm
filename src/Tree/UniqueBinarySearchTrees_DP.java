package Tree;

//LC 96

public class UniqueBinarySearchTrees_DP {
    public static int numTrees(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++)
                sum += dp[j-1] * dp[i - j];
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
/*
set t[0]=1; just for easy calculation.

t[1]=1, means when there is one node, return 1.

When n=2, {1,2}:

If '1' is root, there is 0 node left to build up left branch, and 1 node left to build up right branch.
Thus when n=2, '1' is root, there are t[0] * t[1] trees.

If '2' is root, there is 1 node to build left branch, and 0 node to build right branch. Thus n=2, '2' is root,
there are t[1] * t[0] trees.

So when n=2, there are t[0]*t[1] + t[1]*t[0]; trees.

Use the 'root' to divide 1...n into two parts, then there are t[remaining number of left] * t[remaining number of right]
trees for each 'root'.
*/