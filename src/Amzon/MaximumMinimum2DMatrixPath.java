package Amzon;


//Maximum Minimum Path
//给一个int[][]的matirx，对于一条从左上到右下的path p_i，p_i中的最小值是m_i，求所有m_i中的最大值。只能往下或右
//        比如：
//        [8, 4, 7].鏈枃鍘熷垱鑷�1point3acres璁哄潧
//        [6, 5, 9]
//        有3条path：
//        8-4-7-9 min: 4
//        8-4-5-9 min: 4
//        8-6-5-9 min: 5
//        return: 5
public class MaximumMinimum2DMatrixPath {
    static int maxMin = Integer.MIN_VALUE;
    public static int maxMin(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return maxMin;
        dfs(matrix, 0, 0, Integer.MAX_VALUE);
        return maxMin;
    }

    private static void dfs(int[][] mat, int i, int j, int minSofar) {
        int M = mat.length, N = mat[0].length;
        if (i >= M || j >= N) return;
        minSofar = Math.min(minSofar, mat[i][j]);
        if (i == M - 1 && j == N - 1) {
            maxMin = Math.max(minSofar, maxMin);
        }
        dfs(mat, i + 1, j, minSofar);
        dfs(mat, i, j + 1, minSofar);
    }

    public static void main(String[] args) {
        int[][] a = {{8, 4, 7}, {6, 5, 9}};
        System.out.println((maxMin(a)));
    }
}
