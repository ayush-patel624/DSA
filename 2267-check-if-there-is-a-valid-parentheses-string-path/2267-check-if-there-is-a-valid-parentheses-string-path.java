class Solution {

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 == 1)
            return false;

        if (grid[0][0] == ')')
            return false;

        Boolean[][][] dp = new Boolean[m][n][m + n];

        return helper(grid, dp, 0, 0, 0);
    }

    boolean helper(char[][] grid,
                   Boolean[][][] dp,
                   int r,
                   int c,
                   int balance) {

        if (balance < 0)
            return false;

        if (balance > grid.length + grid[0].length)
            return false;

        if (r == grid.length - 1 &&
            c == grid[0].length - 1) {

            return grid[r][c] == '('
                    ? balance + 1 == 0
                    : balance - 1 == 0;
        }

        if (dp[r][c][balance] != null)
            return dp[r][c][balance];

        int newBalance;

        if (grid[r][c] == '(')
            newBalance = balance + 1;
        else
            newBalance = balance - 1;

        if (newBalance < 0)
            return dp[r][c][balance] = false;

        boolean down = false;
        boolean right = false;

        if (r + 1 < grid.length)
            down = helper(grid, dp, r + 1, c, newBalance);

        if (c + 1 < grid[0].length)
            right = helper(grid, dp, r, c + 1, newBalance);

        return dp[r][c][balance] = down || right;
    }
}