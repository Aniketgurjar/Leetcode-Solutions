class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int lo=0;
        int hi=0;
        for(int i=0;i<n;i++){
            lo=Math.max(lo,nums[i]);
            hi=hi+nums[i];
        }
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(ispossible(nums,k,mid,1)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[]nums,int k ,int mid, int part){
        int sum=0;
        for(int i=0;i<nums.length;i++){

            if(sum+nums[i]>mid){
                part++;
                sum=nums[i];
               

            }else{
               sum=sum+nums[i];

            }
        }
        return (part<=k);
    }
}