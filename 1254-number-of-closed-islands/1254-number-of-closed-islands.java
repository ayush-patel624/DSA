class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) dfs(grid, vis, i, 0, m, n);
            if (grid[i][n - 1] == 0) dfs(grid, vis, i, n - 1, m, n);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) dfs(grid, vis, 0, j, m, n);
            if (grid[m - 1][j] == 0) dfs(grid, vis, m - 1, j, m, n);
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && vis[i][j] == 0) {
                    res++;
                    dfs(grid, vis, i, j, m, n);
                }
            }
        }

        return res;
    }

    void dfs(int[][] grid, int[][] vis, int r, int c, int m, int n) {
        vis[r][c] = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                && grid[nr][nc] == 0 && vis[nr][nc] == 0) {
                dfs(grid, vis, nr, nc, m, n);
            }
        }
    }
}