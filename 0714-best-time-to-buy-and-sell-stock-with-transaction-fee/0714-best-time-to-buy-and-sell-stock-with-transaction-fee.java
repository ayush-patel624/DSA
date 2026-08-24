class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [][] dp = new int[n][2];

        for(int [] row : dp) Arrays.fill(row,-1);

        return helper(prices,dp,0,0,fee);
    }

    int helper(int [] prices,int [][] dp , int idx , int holding,int fee){
        if(idx>= prices.length) return 0;

        if(dp[idx][holding]!=-1) return dp[idx][holding];

        if(holding == 0){
            return dp[idx][holding] = Math.max(-prices[idx] + helper(prices,dp,idx+1,1,fee) , helper(prices,dp,idx+1,0,fee));
        }else{
            return dp[idx][holding] = Math.max(+prices[idx] - fee + helper(prices,dp,idx+1,0,fee) , helper(prices,dp,idx+1,1,fee));
        }
    }
}