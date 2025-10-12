class Solution {
    List<List<Integer>> list; // make list a class member

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u); 
        }
        dfs(destination, vis, source);
        return vis[destination];
    }

    public void dfs(int destination, boolean[] vis, int node) {
        if (vis[node]) {
            return;
        }

        vis[node] = true;

        for (int neighbour : list.get(node)) {
            dfs(destination, vis, neighbour);
        }
    }
}
