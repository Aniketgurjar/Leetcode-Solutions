class Solution {
    int pointer = 0;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int c1 = -1;
        int c2 = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(pointer)) {
                    c1 = i;
                    c2 = j;
                    if (dfs(board, word, c1, c2, n, m)) { // fixed: removed 'return' before 'dfs'
                        return true;
                    }
                }
            }
        }
        return false; // fixed: moved outside both loops
    }

    public boolean dfs(char[][] board, String word, int i, int j, int n, int m) {
        if (pointer >= word.length()) { 
           
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n  || board[i][j] != word.charAt(pointer)) {
            return false;
        }

        if (board[i][j] == word.charAt(pointer)) {
            pointer++;
        }

        char ch = board[i][j];
        board[i][j] = '#';

        boolean choice1 = dfs(board, word, i + 1, j, n, m);
        boolean choice2 = dfs(board, word, i, j + 1, n, m);
        boolean choice3 = dfs(board, word, i - 1, j, n, m);
        boolean choice4 = dfs(board, word, i, j - 1, n, m);

        board[i][j] = ch;
        pointer--;

        return choice1 || choice2 || choice3 || choice4;
    }
}
