class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int [] dp = new int[amount+1];
        Arrays.fill(dp,(int)1e9);
        dp[0]=0;

        for(int i : coins){
            for(int j=i;j<=amount;j++){
                dp[j]= Math.min(dp[j],dp[j-i]+1);
            }
        }

        return dp[amount]>=(int)1e9 ? -1 : dp[amount];
    }
}