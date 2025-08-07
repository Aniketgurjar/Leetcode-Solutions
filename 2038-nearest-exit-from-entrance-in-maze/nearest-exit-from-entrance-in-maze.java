// pair class to store coordinates (row and column)
class pair {
    int first;
    int second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;        // total number of rows
        int m = maze[0].length;     // total number of columns

        // 4 possible directions: down, up, right, left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<pair> q = new LinkedList<>();         // BFS ke liye queue
        boolean[][] vis = new boolean[n][m];        // visited cells ko track karne ke liye
        int steps = 0;                              // steps count karne ke liye

        // entrance cell ko queue me daalo aur visited mark karo
        q.add(new pair(entrance[0], entrance[1]));
        vis[entrance[0]][entrance[1]] = true;

        // jab tak queue empty nahi hoti
        while (!q.isEmpty()) {
            int size = q.size(); // current level ke kitne elements hain

            for (int i = 0; i < size; i++) {
                pair p = q.poll();  // queue se ek cell nikaalo

                int x0 = p.getFirst();   // row
                int y0 = p.getSecond();  // column

                // agar yeh cell boundary pe hai aur entrance nahi hai to yeh exit hai
                if ((x0 != entrance[0] || y0 != entrance[1]) &&
                    (x0 == 0 || x0 == n - 1 || y0 == 0 || y0 == m - 1)) {
                    return steps; // nearest exit mil gaya
                }

                // check 4 directions
                for (int[] dir : directions) {
                    int x = x0 + dir[0];
                    int y = y0 + dir[1];

                    // agar valid cell hai, path open hai ('.') aur pehle visit nahi hua
                    if (x >= 0 && y >= 0 && x < n && y < m &&
                        maze[x][y] == '.' && !vis[x][y]) {
                        q.add(new pair(x, y));    // queue me daalo
                        vis[x][y] = true;         // visited mark karo
                    }
                }
            }

            steps++; // ek level complete ho gaya, step badhao
        }

        return -1; // koi exit nahi mila
    }
}
