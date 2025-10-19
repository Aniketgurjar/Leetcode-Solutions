class pair{
    int u;
    int v;
    int w;
    public pair(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
        public int getU(){
            return u;
        }
        public int getV(){
            return v;
        }
        public int getW(){
            return w;
        }
    }

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
            parent[yParent] = xParent;
            rank[yParent]++;
        }
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
    PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
    int n=points.length;
    
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            pq.add(new pair(
    i,
    j,
    Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])
));
        }
    }

   int sum=0;
   DSU dsu=new DSU(n);
while(pq.size()>0){
    pair p=pq.poll();
    int node1=p.getU();
    int node2=p.getV();

   
    if(dsu.find(node1)!=dsu.find(node2)){
        sum=sum+p.getW();
dsu.union(node1,node2);
    }

}
return sum;

    }
}