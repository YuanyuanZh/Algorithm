package DFS;


public class LongestIncreasingPathinMatrix {
    public static int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int max = 0, n = matrix.length, m = matrix[0].length;

        // create a cache matrix
        int[][] cache = new int[n][m];

        // dfs search on every element in matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, cache), max);
            }
        }
        return max;
    }

    static int dfs(int[][] matrix, int min, int i, int j, int[][] cache) {

        // check boundary limits
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
            return 0;

        // check min condition
        if (matrix[i][j] <= min)
            return 0;

        // check into cache
        if (cache[i][j] != 0)
            return cache[i][j];

        // update min
        min = matrix[i][j];

        // run dfs in all four directions
        int a = dfs(matrix, min, i - 1, j, cache) + 1;
        int b = dfs(matrix, min, i + 1, j, cache) + 1;
        int c = dfs(matrix, min, i, j - 1, cache) + 1;
        int d = dfs(matrix, min, i, j + 1, cache) + 1;

        // find max and update cache
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;

        return max;
    }

    public static void main(String[] args) {
        int[][] a = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        int[][] b = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(a));
        System.out.println(longestIncreasingPath(b));
    }
}
