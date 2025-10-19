class pair{
    int first;
    int second;
    int level;
    pair(int first,int second,int level){
        this.first=first;
        this.second=second;
        this.level=level;
    }
    public int getfirst(){
        return first;
    }
    public int getsecond(){
        return second;
    }
    public int getlevel(){
        return level;
    }
}
class Solution {
    int[][]dir={{1,0},{-1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean[][]vis=new boolean[m][n];
        int[][]ans=new int[m][n];
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new pair(i,j,0));
                    vis[i][j]=true;
                    ans[i][j]=0;
                }
            }
        }
        while(q.size()>0){
pair p=q.poll();
int l=p.getlevel();
for(int i=0;i<4;i++){
    int x=p.getfirst();
    int y=p.getsecond();
    x=x+dir[i][0];
    y=y+dir[i][1];
    if((x>=0&&x<m)&&(y>=0&&y<n)&&!vis[x][y]){
        q.add(new pair(x,y,l+1));
        vis[x][y]=true;
    
    if(mat[x][y]==1){
        ans[x][y]=l+1;
    }
    }
}
        }
        return ans;
        
    }
}