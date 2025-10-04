class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int hi = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            hi = Math.max(hi, nums[i]);
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (ispossible(nums, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean ispossible(int[] nums, int target) {
        long[] nums1 = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }

        for (int i = nums1.length - 1; i >= 1; i--) {
            if (nums1[i] > target) {
                long diff = nums1[i] - target;
                nums1[i] -= diff;
                nums1[i - 1] += diff;
            }
        }
        return nums1[0] <= target;
    }
}
