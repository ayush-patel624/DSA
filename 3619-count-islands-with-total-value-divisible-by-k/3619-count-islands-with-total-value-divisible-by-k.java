class Solution {
    long sum=0;
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] vis = new int[m][n];

        int res=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum=0;
                if(grid[i][j]!=0 && vis[i][j]==0){
                    dfs(grid,vis,m,n,i,j);
                }
                if(sum!=0 && sum%k==0) res+=1;
            }
        }

        return res;
    }

    void dfs(int[][] grid , int[][] vis , int m , int n , int r , int c ){
        vis[r][c]=1;
        sum+=grid[r][c];

        int [] dx = new int[]{-1,0,1,0};
        int [] dy = new int[]{0,1,0,-1};

        for(int i=0;i<4;i++){
            int nr = r +dx[i];
            int nc = c +dy[i];

            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]!=0 && vis[nr][nc]==0){
                dfs(grid,vis,m,n,nr,nc);
            }
        }

    }
}