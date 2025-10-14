class Solution {
    int prev=0;
    int n;
    int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        prev=image[sr][sc];
         m=image.length;
         n=image[0].length;
        dfs(image,color,sr,sc);
        return image;
    }
    public void dfs(int[][]image,int color,int i,int j){
if(i<0||i>m-1||j<0||j>n-1){
    return;
}
if(image[i][j]==color||image[i][j]!=prev){
    return;
}



        if(image[i][j]==prev){
            image[i][j]=color;
            dfs(image,color,i+1,j);
            dfs(image,color,i-1,j);
            dfs(image,color,i,j-1);
            dfs(image,color,i,j+1);
        }
    }
}