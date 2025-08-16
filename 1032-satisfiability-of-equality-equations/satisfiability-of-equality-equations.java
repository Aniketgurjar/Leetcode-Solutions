import java.util.*;

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
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                dsu.union(a, b);
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                if (dsu.find(a) == dsu.find(b)) {
                    return false;
                }
            }
        }

        return true;
    }
}
