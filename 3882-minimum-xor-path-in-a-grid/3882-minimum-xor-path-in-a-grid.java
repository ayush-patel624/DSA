class Solution {
    int[][][] dp;
    int m, n, maxXor;

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        maxXor = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxXor |= val;
            }
        }

        dp = new int[m][n][maxXor + 1];

        for (int[][] plane : dp) {
            for (int[] row : plane) {
                Arrays.fill(row, -1);
            }
        }

        return helper(grid, 0, 0, 0);
    }

    int helper(int[][] grid, int i, int j, int xor) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        xor ^= grid[i][j];

        if (i == m - 1 && j == n - 1) {
            return xor;
        }

        if (dp[i][j][xor] != -1) {
            return dp[i][j][xor];
        }

        int down = helper(grid, i + 1, j, xor);
        int right = helper(grid, i, j + 1, xor);

        return dp[i][j][xor] = Math.min(down, right);
    }
}