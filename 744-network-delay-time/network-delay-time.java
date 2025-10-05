import java.util.*;

class pair {
    int to;
    int distance;

    pair(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }

    public int to() {
        return to;
    }

    public int distance() {
        return distance;
    }
}

class Solution {
    List<List<int[]>> list = new ArrayList<>();
    PriorityQueue<pair> pq;

    public int networkDelayTime(int[][] times, int n, int k) {
        pq = new PriorityQueue<>(Comparator.comparingInt(pair::distance));

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] t : times) {
            list.get(t[0] - 1).add(new int[]{t[1] - 1, t[2]});
        }

        pq.add(new pair(k - 1, 0));
        dist[k - 1] = 0;

        dij(dist, n);

        int ans = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, d);
        }
        return ans;
    }

    public void dij(int[] dist, int n) {
        while (pq.size() > 0) {
            pair p = pq.poll();
            int from = p.to();
            for (int[] arr : list.get(from)) {
                int total = p.distance();
                if (arr[1] + total < dist[arr[0]]) {
                    pq.add(new pair(arr[0], arr[1] + total));
                    dist[arr[0]] = arr[1] + total;
                }
            }
        }
    }
}
