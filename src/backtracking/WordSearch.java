package backtracking;


public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && search (board, word, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean search (char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0||i >= board.length || j >= board[i].length ||  j < 0 || board[i][j] != word.charAt(index) || visited[i][j] )
            return false;
        visited[i][j] = true;
        if (search (board, word, visited, i+1, j, index+1) ||
                search (board, word, visited, i-1, j, index+1) ||
                search (board, word, visited, i, j-1, index+1) ||
                search (board, word, visited, i, j+1, index+1) )
            return true;
        visited[i][j] = false;
        return false;
    }
}
