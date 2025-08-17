class Solution {
    Double[][][] memo;

    public double knightProbability(int n, int k, int row, int column) {
        memo = new Double[n][n][k+1];
        return dfs(n, k, row, column);
    }

    public double dfs(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[row][column][k] != null) {
            return memo[row][column][k];
        }

        double choice1 = dfs(n, k-1, row-2, column+1);
        double choice2 = dfs(n, k-1, row-2, column-1);
        double choice3 = dfs(n, k-1, row-1, column-2);
        double choice4 = dfs(n, k-1, row+1, column-2);
        double choice5 = dfs(n, k-1, row+2, column-1);
        double choice6 = dfs(n, k-1, row+2, column+1);
        double choice7 = dfs(n, k-1, row-1, column+2);
        double choice8 = dfs(n, k-1, row+1, column+2);

        return memo[row][column][k] = (choice1 + choice2 + choice3 + choice4 + 
                choice5 + choice6 + choice7 + choice8) / 8.0;
    }
}
