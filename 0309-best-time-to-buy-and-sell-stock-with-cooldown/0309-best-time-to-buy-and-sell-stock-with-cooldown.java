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

    int helper(int [] prices,int [][][] dp , int idx , int holding ,int cooldown){
        if(idx>= prices.length) return 0;

        if(dp[idx][holding][cooldown]!=-1) return dp[idx][holding][cooldown];

        if(holding == 0 && cooldown==0){
            return dp[idx][holding][cooldown] = Math.max(-prices[idx] + helper(prices,dp,idx+1,1,cooldown) , helper(prices,dp,idx+1,0,cooldown));
        }else if(holding==1){
            return dp[idx][holding][cooldown] = Math.max(+prices[idx]+ helper(prices,dp,idx+1,0,cooldown+1) , helper(prices,dp,idx+1,1,cooldown));
        }else{
            return dp[idx][holding][cooldown] = helper(prices,dp,idx+1,0,0);
        }
    }
}