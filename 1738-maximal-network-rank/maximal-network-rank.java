class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
      
        int ans=0;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());

        }
        
        for(int[]arr:roads){
        int from=arr[0];
        int to=arr[1];
        list.get(from).add(to);
       list.get(to).add(from);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a=list.get(i).size();
                int b=list.get(j).size();
                int deg=a+b;
                if(list.get(i).contains(j)){
    deg--;
}
ans=Math.max(ans,deg);

            }
        }
return ans;
    }
}