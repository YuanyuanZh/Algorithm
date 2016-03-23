package Amzon.OA2;

import java.util.LinkedList;
import java.util.Queue;

/*
给个array,其中只有一格是9，其他格子是0或1，0表示此路不通，1表示可以走，判断从（0,0) 点开始上下左右移动能否找到这个是9的格子
*/
public class findPathIn2DMatrixMaze {
    public static class Point{
        public int row;
        public int col;
        public Point(int _row, int _col){
            row = _row;
            col = _col;
        }
    }
    public static int Solution(int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length ==0) return  0;
        if (maze[0][0] == 9) return 1;
        int row = maze.length;
        int col = maze[0].length;
        int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(0,0));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tmpRow = cur.row + direction[i][0];
                int tmpCol = cur.col + direction[i][1];
                if(tmpRow >= 0 && tmpCol >= 0 && tmpRow < row && tmpCol < col && maze[tmpRow][tmpCol] > 0){//此处原来是 >0
                    if(maze[tmpRow][tmpCol] == 9) return 1;
                    queue.offer(new Point(tmpRow, tmpCol));
                    maze[tmpRow][tmpCol] = -1;
                }
            }
        }
        return 0;
    }

    public static boolean findPath(int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length ==0) return false;
        boolean [][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze,visited,0,0);
    }

    public static boolean dfs(int[][] maze,boolean [][] visited, int i, int j) {
        if(i < 0 || i >= maze.length || j < 0 || j >= maze[0].length) return false;
        if (maze[i][j] == 9) return true;
        if (maze[i][j] == 0) return false;
        if (!visited[i][j]) {
            visited[i][j] = true;
            if( dfs(maze,visited,i-1,j) || dfs(maze,visited,i+1,j)|| dfs(maze, visited,i, j-1)|| dfs(maze,visited, i,j+1))
                return true;
            visited[i][j] = false;
//            return flag;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze ={{1,1,0},{0,1,0},{0,1,9}};
        int[][] maze1 ={{1,0,0},{1,1,0},{0,1,9}};
        System.out.println(findPath(maze));
        System.out.println(findPath(maze1));
        System.out.println(Solution(maze));
        System.out.println(Solution(maze1));
    }
}
