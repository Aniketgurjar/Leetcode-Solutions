import java.util.*;

class pair {
    int color;
    int neigh;

    pair(int neigh, int color) {
        this.neigh = neigh;
        this.color = color;
    }

    public int getcolor() {
        return color;
    }

    public int getneigh() {
        return neigh;
    }
}

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> list = new ArrayList<>();
        int[] vis = new int[n + 1];
        Queue<pair> q = new LinkedList<>();
if (dislikes.length == 0) return true;

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < dislikes.length; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
for(int j=1;j<=n;j++){
    if(vis[j]==0){
        q.add(new pair(j, 1));
        vis[j]=1;
    }
        

        while (q.size() > 0) {
            pair p = q.poll();
            int c = p.getcolor();
            int node = p.getneigh();

            for (int i = 0; i < list.get(node).size(); i++) {
                int neighbour = list.get(node).get(i);
                if (vis[neighbour] != 0 && vis[neighbour] == c) {
                    return false;
                }
                if (vis[neighbour] == 0) {
                    if (c == 1) {
                        q.add(new pair(neighbour, 2));
                        vis[neighbour] = 2;
                    } else {
                        q.add(new pair(neighbour, 1));
                        vis[neighbour] = 1;
                    }
                }
            }
        }
}
        return true;
    }
}
