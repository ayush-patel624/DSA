
class Solution {
    private static final int MOD = 1_000_000_007;

    private int m, n;
    private int[][] grid;
    private int[][] dp;
    private int[][][] memo;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        memo = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(dp[i], -1);

            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(memo[i][j], -2);
            }
        }

        return dfs(0, 0);
    }

    // Count paths starting from a non-mirror cell.
    private int dfs(int r, int c) {

        if (r >= m || c >= n) return 0;

        if (r == m - 1 && c == n - 1) return 1;

        if (dp[r][c] != -1) return dp[r][c];

        long ans = 0;

        // Move right
        int next = resolve(r, c + 1, 0);

        if (next != -1) {
            ans += dfs(next / n, next % n);
        }

        // Move down
        next = resolve(r + 1, c, 1);

        if (next != -1) {
            ans += dfs(next / n, next % n);
        }

        return dp[r][c] = (int)(ans % MOD);
    }

    // Resolve consecutive mirror reflections.
    // dir = 0: moving right
    // dir = 1: moving down
    private int resolve(int r, int c, int dir) {

        if (r >= m || c >= n) return -1;

        if (memo[r][c][dir] != -2) {
            return memo[r][c][dir];
        }

        // Empty cell: robot can stop here.
        if (grid[r][c] == 0) {
            return memo[r][c][dir] = r * n + c;
        }

        int result;

        if (dir == 0) {
            // Right into mirror -> turn down.
            result = resolve(r + 1, c, 1);
        } else {
            // Down into mirror -> turn right.
            result = resolve(r, c + 1, 0);
        }

        return memo[r][c][dir] = result;
    }
}
