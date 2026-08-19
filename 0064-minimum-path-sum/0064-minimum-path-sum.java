class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] dp = new int[n][m];

        for(int [] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        dp[0][0]=grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i-1>=0) dp[i][j] = Math.min(grid[i][j] + dp[i-1][j] , dp[i][j]);
                if(j-1>=0) dp[i][j] = Math.min(grid[i][j] + dp[i][j-1] , dp[i][j]);
            }
        }

        return dp[n-1][m-1];
    }
}