package Amzon.OA2;

// Rotate matrix 90 (鉴于不是m*m，没法in place)，（0为右转，1为左转）
// m*m 的话不需要extra array space
public class RotateMatrix {
    public static int[][] rotate(int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0].length == 0) {
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[cols][rows];//转过来,如果是m*m的话可以inplace
        if (flag == 0) {
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    res[j][rows - 1 - i] = matrix[i][j];
                }
            }
        } else if (flag == 1) {
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    res[cols - 1 -j][i] = matrix[i][j];
                }
            }
        }
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
////                res[j][rows - 1 - i] = matrix[i][j];
//                res[i][j] = flag == 0? matrix[cols-1-j][i]:matrix[j][rows-1-i];
//            }
//        }
//        for(int i = 0; i < cols; ++i)
//            for(int j = 0; j < rows; ++j)
//                // if flag equals 0, then clockwise rotate; if flag is 1, rotate anticlockwise
//                res[i][j] = flag == 0 ? matrix[rows - 1 - j][i] : matrix[j][cols - 1 - i];
        return res;
    }

    public static int[][] transpose(int[][] input) {
        int[][] res = new int[input[0].length][input.length];
        for(int i = 0; i< res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = input[j][i];
            }
        }
        return res;
    }

    public static int[][] rotate1(int[][] input, int flag) {
        int[][] t = transpose(input);
        if (flag == 0) {
            for (int i = 0; i < t[0].length; i++) {
                for (int j = 0; j < t.length/2; j++) {
                    int tmp = t[j][i];
                    t[j][i] = t[t.length-1-j][i];
                    t[t.length-1-j][i] = tmp;
                }
            }
        }
        else {
            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t[i].length/2; j++) {
                    int tmp = t[i][j];
                    t[i][j] = t[i][t[0].length-1-j];
                    t[i][t[0].length-1-j] = tmp;
                }
            }
        }
        return t;
    }

    public static void printMatrix(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        //printMatrix(a);
//        printMatrix(transpose(a));
        printMatrix(rotate(a,1));
//        printMatrix(rotate1(a,1));
        printMatrix(rotate(a,0));
//        printMatrix(rotate1(a,0));
    }

}
