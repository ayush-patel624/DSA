class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {

                    if (dp[i - 1][j][k] == -1)
                        continue;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {

                            int pos1 = j + d1;
                            int pos2 = k + d2;

                            if (pos1 >= 0 && pos1 < m &&
                                pos2 >= 0 && pos2 < m) {

                                int cherries = grid[i][pos1];

                                if (pos1 != pos2) {
                                    cherries += grid[i][pos2];
                                }

                                dp[i][pos1][pos2] =
                                    Math.max(
                                        dp[i][pos1][pos2],
                                        dp[i - 1][j][k] + cherries
                                    );
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                ans = Math.max(ans, dp[n - 1][j][k]);
            }
        }

        return ans;
    }
}