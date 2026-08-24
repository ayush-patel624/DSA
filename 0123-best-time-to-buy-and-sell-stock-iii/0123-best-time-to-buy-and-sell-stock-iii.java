class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int [][][] dp = new int[n][2][2];

        for(int [][] mat : dp){
            for(int [] row : mat){
                Arrays.fill(row,-1);
            }
        }

        return helper(prices,dp,0,0,0);

    }
    int helper(int [] prices,int [][][] dp , int idx , int holding,int k){
        if(idx>= prices.length || k>=2) return 0;

        if(dp[idx][holding][k]!=-1) return dp[idx][holding][k];

        if(holding == 0){
            return dp[idx][holding][k] = Math.max(-prices[idx] + helper(prices,dp,idx+1,1,k) , helper(prices,dp,idx+1,0,k));
        }else{
            return dp[idx][holding][k] = Math.max(+prices[idx]+ helper(prices,dp,idx+1,0,k+1) , helper(prices,dp,idx+1,1,k));
        }
    }
}