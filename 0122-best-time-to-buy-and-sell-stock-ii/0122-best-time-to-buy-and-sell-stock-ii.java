class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n][2];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        return helper(prices,dp,0,0);
    }

    int helper(int [] prices,int [][] dp , int idx , int holding){
        if(idx>= prices.length) return 0;

        if(dp[idx][holding]!=-1) return dp[idx][holding];

        if(holding == 0){
            return dp[idx][holding] = Math.max(-prices[idx] + helper(prices,dp,idx+1,1) , helper(prices,dp,idx+1,0));
        }else{
            return dp[idx][holding] = Math.max(+prices[idx]+ helper(prices,dp,idx+1,0) , helper(prices,dp,idx+1,1));
        }
    }
}