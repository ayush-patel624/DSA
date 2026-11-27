
class Solution {
    int[][][] dp;

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && items[j][0]%items[i][0]==0){
                    free[i]++;
                }
            }
        }

        dp = new int[n][budget+1][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<=budget;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return helper(items,free,0,budget,0);
    }

    int helper(int[][] items,int[] free,int idx,int budget,int bought){
        if(idx==items.length) return 0;

        if(dp[idx][budget][bought]!=-1){
            return dp[idx][budget][bought];
        }

        int ans = helper(items,free,idx+1,budget,0);

        if(budget>=items[idx][1]){
            int val;

            if(bought==0){
                val = free[idx]+1+
                    helper(items,free,idx,budget-items[idx][1],1);
            }else{
                val = 1+
                    helper(items,free,idx,budget-items[idx][1],1);
            }

            ans = Math.max(ans,val);
        }

        return dp[idx][budget][bought]=ans;
    }
}
