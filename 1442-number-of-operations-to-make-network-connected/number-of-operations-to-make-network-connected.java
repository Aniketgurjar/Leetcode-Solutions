class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank   = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
       
        int k=connections.length;
        int component=n;
        if(connections.length<n-1){
            return -1;
        }
       DSU dsu=new DSU(n);
        for(int[]arr:connections){
            int a=arr[0];
            int b=arr[1];
if(dsu.find(a)!=dsu.find(b)){
    component--;
    dsu.union(a,b);
}

        }
       return component-1;
    }
}