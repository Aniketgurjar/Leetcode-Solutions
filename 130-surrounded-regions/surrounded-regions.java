class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, vis, m, n);
            }
        }

        for (int i = 1; i < m; i++) {
            dfs(board, i, n - 1, vis, m, n);
        }

        if (m > 1) {
            for (int j = n - 2; j >= 0; j--) {
                dfs(board, m - 1, j, vis, m, n);
            }
        }

        if (n > 1) {
            for (int i = m - 2; i > 0; i--) {
                dfs(board, i, 0, vis, m, n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, boolean[][] vis, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (vis[i][j] || board[i][j] == 'X') {
            return;
        }

        board[i][j] = '#';
        vis[i][j] = true;

        dfs(board, i + 1, j, vis, m, n);
        dfs(board, i - 1, j, vis, m, n);
        dfs(board, i, j - 1, vis, m, n);
        dfs(board, i, j + 1, vis, m, n);
    }
}
