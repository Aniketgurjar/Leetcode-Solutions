class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank   = new int[n];
        for (int i =1; i < n; i++) {
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
    public int[] findRedundantConnection(int[][] edges) {
        int l=edges.length+1;
        int []ans=new int[2];
DSU dsu=new DSU(l);
for(int[]arr:edges){
    if(dsu.find(arr[0])==dsu.find(arr[1])){
ans[0]=arr[0];
ans[1]=arr[1];

}else{
    dsu.union(arr[0],arr[1]);
}
}
return ans;
        
    }
}