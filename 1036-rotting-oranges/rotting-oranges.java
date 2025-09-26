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

    public int getfirst() {
        return first;
    }

    public int getsecond() {
        return second;
    }

    public int getlevel() {
        return level;
    }
}

class Solution {
    int[][] dir = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = -2;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int l = p.getlevel();
            for (int i = 0; i < 4; i++) {
                int x = p.getfirst() + dir[i][0];
                int y = p.getsecond() + dir[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -2 && grid[x][y] != 0) {
                    grid[x][y] = -2;
                    q.add(new Pair(x, y, l + 1));
                }
            }
            ans = Math.max(l, ans);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
