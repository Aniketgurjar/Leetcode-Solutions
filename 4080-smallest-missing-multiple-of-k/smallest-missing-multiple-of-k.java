class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>hs=new HashSet<>();
        for(int i:nums){
            hs.add(i);
        }
        int val=k;
        while(true){
            if(!hs.contains(val)){
                return val;
            }
            val=val+k;
        }
        
    }
}