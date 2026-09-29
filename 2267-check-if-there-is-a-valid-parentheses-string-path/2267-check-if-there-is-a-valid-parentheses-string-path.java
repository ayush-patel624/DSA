class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==')') return false;

        Boolean [][][] dp = new Boolean[m][n][m+n];

        return helper(dp,grid,0,0,0);
    }

    boolean helper(Boolean [][][] dp , char [][] grid , int r , int c , int balance){
        if(r>= grid.length || c>= grid[0].length) return false;

        if(balance<0) return false;

        if(dp[r][c][balance]!=null) return dp[r][c][balance];

        if(r==grid.length-1 && c==grid[0].length-1){
            return dp[r][c][balance] = grid[r][c]=='(' ? balance+1==0 : balance-1==0;
        }

        if(grid[r][c]=='('){
            return dp[r][c][balance] = helper(dp,grid,r+1,c,balance+1) || helper(dp,grid,r,c+1,balance+1);
        }

        return dp[r][c][balance] = helper(dp,grid,r+1,c,balance-1) || helper(dp,grid,r,c+1,balance-1);
    }
}