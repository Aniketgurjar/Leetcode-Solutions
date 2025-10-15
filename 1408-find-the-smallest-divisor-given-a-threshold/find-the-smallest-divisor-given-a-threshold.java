class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long lo = 1;
        long hi = 0;
        for (int num : nums) {
            hi += (long) num; 
        }
        int ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isPossible(nums, threshold, mid)) {
                ans = (int) mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int threshold, long mid) {
        long sum = 0;
        for (int num : nums) {
            sum += (num + mid - 1) / mid; 
            if (sum > threshold) return false; 
        }
        return sum <= threshold;
    }
}
