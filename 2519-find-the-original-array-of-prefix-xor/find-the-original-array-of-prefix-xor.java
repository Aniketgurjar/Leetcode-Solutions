class Solution {
    public int[] findArray(int[] pref) {
int []ans=new int[pref.length];
for(int i=1;i<pref.length;i++){
    ans[i]=pref[i-1]^pref[i];
}
ans[0]=pref[0];
return ans;
    }
}