import java.util.*;

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                Arrays.fill(dp[i][j1], -1);
            }
        }

        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];

        for (int i = 1; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int best = -1;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {

                            int p1 = j1 - d1;
                            int p2 = j2 - d2;

                            if (p1 >= 0 && p1 < n &&
                                p2 >= 0 && p2 < n) {

                                best = Math.max(best, dp[i - 1][p1][p2]);
                            }
                        }
                    }

                    if (best == -1)
                        continue;

                    dp[i][j1][j2] = best + grid[i][j1];

                    if (j1 != j2)
                        dp[i][j1][j2] += grid[i][j2];
                }
            }
        }

        int ans = 0;

        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                ans = Math.max(ans, dp[m - 1][j1][j2]);
            }
        }

        return ans;
    }
}