import java.util.*;

class pair {
    int standing;
    int distance;
    int stops;

    pair(int standing, int distance, int stops) {
        this.standing = standing;
        this.distance = distance;
        this.stops = stops;
    }

    public int getstanding() {
        return standing;
    }

    public int getdistance() {
        return distance;
    }

    public int getstops() {
        return stops;
    }
}

class Solution {
    List<List<int[]>> list;
    PriorityQueue<pair> pq;
    int[] dist;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        list = new ArrayList<>();
        pq = new PriorityQueue<>(Comparator.comparingInt(pair::getstops));
        dist = new int[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < flights.length; i++) {
            list.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        dist[src] = 0;
        pq.add(new pair(src, 0, 0));
        dij(src, dst, k);

     if( dist[dst]==Integer.MAX_VALUE){
        return -1;
     }
     return dist[dst];
    
    }

    public void dij(int src, int dst, int k) {
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int current = p.getstanding();
            int newstop = p.getstops();

            for (int[] arr : list.get(current)) {
                int totaldis = p.getdistance() + arr[1];
                if (totaldis < dist[arr[0]]) {
                    if ((newstop == k && arr[0] == dst) || newstop < k) {
                        pq.add(new pair(arr[0], totaldis, newstop + 1));
                        dist[arr[0]] = totaldis;
                    }
                }
            }
        }
    }
}
