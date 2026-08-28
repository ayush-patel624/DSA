class Solution {
    int res = 0;

    public int minIncrements(int n, int[] cost) {
        helper(1, n, cost);
        return res;
    }

    int helper(int node, int n, int[] cost) {
        if (node > n) {
            return 0;
        }

        int left = helper(2 * node, n, cost);
        int right = helper(2 * node + 1, n, cost);

        res += Math.abs(left - right);

        return cost[node - 1] + Math.max(left, right);
    }
}