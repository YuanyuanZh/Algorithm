package DFS;

public class NumberofIslands {
    public static int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int c = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfsHelper(grid, visited, i, j);
                    c++;
                }
            }
        }
        return c;
    }

    public static void dfsHelper(char[][] grid, boolean[][] visited, int i, int j) {
        if(i<0 || j<0 || i >=grid.length || j >= grid[0].length)
            return;
        if(visited[i][j] || grid[i][j] == 0)
            return;
        visited[i][j] = true;
        dfsHelper(grid, visited, i+1, j);
        dfsHelper(grid, visited, i-1, j);
        dfsHelper(grid, visited, i, j+1);
        dfsHelper(grid, visited, i, j-1);
    }

    public static void main(String[] args) {
        char [][] a = {{'1'}};
        System.out.println(numIslands(a));
    }
}
