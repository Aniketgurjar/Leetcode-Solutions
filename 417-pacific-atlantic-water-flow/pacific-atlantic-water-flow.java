class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean[][] pacificF;
    boolean[][] atlanticF;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        pacificF = new boolean[m][n];
        atlanticF = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, true, false,0,i);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, true, false,i,0);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, m - 1, i, false, true,m-1,i);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, false, true,i,n-1);
        }

        return list;
    }

    public void dfs(int[][] heights, int i, int j, boolean pacific, boolean atlantic,int prevI, int prevJ) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
if(heights[i][j]<heights[prevI][prevJ]){
return;
}
        if (pacific && pacificF[i][j]) return;
        if (atlantic && atlanticF[i][j]) return;

        if (pacific) pacificF[i][j] = true;
        if (atlantic) atlanticF[i][j] = true;

        if (atlantic && pacificF[i][j]) {
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            newList.add(j);
        list.add(newList);
        }

        dfs(heights, i + 1, j, pacific, atlantic,i,j);
        dfs(heights, i - 1, j, pacific, atlantic,i,j);
        dfs(heights, i, j + 1, pacific, atlantic,i,j);
        dfs(heights, i, j - 1, pacific, atlantic,i,j);
    }
}
