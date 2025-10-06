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
    int[][] dir = {
    {-1, 0},  // up
    {1, 0},   // down
    {0, -1},  // left
    {0, 1},   // right
    {-1, -1}, // top-left
    {-1, 1},  // top-right
    {1, -1},  // bottom-left
    {1, 1}    // bottom-right
};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        Queue<pair>q=new LinkedList<>();
        boolean[][]vis=new boolean[n][n];
        if(grid[0][0]==1){
            return -1;
        }
        if (n == 1 && grid[0][0] == 0) {
    return 1;
}

        q.add(new pair(0,0,1));
        vis[0][0]=true;
        while(q.size()>0){
            pair p=q.poll();
            int l=p.getlevel();
            
            for(int i=0;i<8;i++){
                int x=p.getfirst();
            int y=p.getsecond();
                x=x+dir[i][0];
                y=y+dir[i][1];
                if(x>=0&&x<=n-1&&y>=0&&y<=n-1&&!vis[x][y]&&grid[x][y]==0){
                    if(x==n-1&&y==n-1){
                        return l+1;
                    }
                     vis[x][y]=true;
                    q.add(new pair(x,y,l+1));
                   
                }
            }
        }
return -1;
    }
}