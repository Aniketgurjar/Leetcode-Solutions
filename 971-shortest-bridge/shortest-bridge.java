import java.util.*;

class Pair {
    int first;
    int second;
    int level;

    Pair(int first, int second, int level) {
        this.first = first;
        this.second = second;
        this.level = level;
    }

    public int getfirst() { return first; }
    public int getsecond() { return second; }
    public int getlevel() { return level; }
}

class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<Pair> q = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean found = false;

        for (int i = 0; i < m; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, m, n);
                    found = true;
                    break;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int l = p.getlevel();
            for (int[] dir : directions) {
                int x = p.getfirst() + dir[0];
                int y = p.getsecond() + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == 1) {
                        return l;
                    }
                    if (grid[x][y] == 0) {
                        grid[x][y] = -1;
                        q.add(new Pair(x, y, l + 1));
                    }
                }
            }
        }
        return -1;
    }

    public void dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        q.add(new Pair(i, j, 0));
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
