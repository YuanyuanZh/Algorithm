package Array;


public class Searcha2DMatrix {

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length;
        while (row < matrix.length && col >= 0) {
            if (target < matrix[row][col]) col --;
            else if (target > matrix[row][col]) row ++;
            else return true;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return helper( matrix, target, 0, matrix.length-1, 0,matrix[0].length-1);
    }

    public static boolean helper (int[][] matrix, int target, int rs, int re, int cs, int ce) {
        if (rs == re) {
            if (cs > ce) return false;
            if (cs == ce) return matrix[rs][cs] == target;
            int cmid = cs + (ce - cs)/2;
            if (matrix[rs][cmid] > target) return helper (matrix, target, rs, rs, cs , cmid-1);
            else if (matrix[rs][cmid] < target) return helper (matrix, target, rs, rs, cmid+1 , ce);
            else return true;
        }
        if (rs > re) {
            return false;
        }
        int rmid = rs + (re - rs)/2;
        if (matrix[rmid][0] > target) {
            return helper (matrix, target, rs, rmid-1, cs, ce);
        }
        else if (matrix[rmid][ce] < target)  {
            return helper (matrix, target, rmid + 1, re, cs, ce);
        }
        else {
            return helper (matrix, target, rmid, rmid, cs, ce);
        }
    }




    public static void main(String[] args) {
        int [][] matrix = {{-10, -8, -8, -8},{-5, -4, -2, 0}};
        System.out.println(searchMatrix(matrix,7));
     }
}
