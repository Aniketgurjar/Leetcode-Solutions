class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int lo = 1; 
        int hi = 10000000;  
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(dist, mid, n, hour)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] dist, int speed, int n, double hour) {
        double time = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                time += Math.ceil((double)dist[i] / speed);
            } else {
                time += (double)dist[i] / speed;
            }
        }
        return time <= hour;
    }
}
