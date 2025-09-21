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

        if (xParent == yParent){
             return;
        }

        if (xParent < yParent) {
            parent[yParent] = xParent;
        } else if(xParent > yParent) {
            parent[xParent] = yParent;
       
    }
}
}
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu=new DSU(26);
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s1.length();i++){
            int a=s1.charAt(i)-'a';
            int b=s2.charAt(i)-'a';
           dsu.union(a,b);
        }
        for(int i=0;i<baseStr.length();i++){
int c = baseStr.charAt(i) - 'a';
sb.append((char)(dsu.find(c) + 'a'));
        }
        return sb.toString();
    }
}