class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum=0;
        for(int i : nums) sum+=i;

        if((sum+target) % 2 != 0 || (sum+target)<0) return 0; 

        int t = (sum+target)/2;

        int [] dp = new int[t+1];
        dp[0]= 1;

        for(int i=0;i<n;i++){
            for(int j=t;j-nums[i]>=0;j--){
                dp[j]= dp[j] + dp[j-nums[i]];
            }
        }

        return dp[t];
    }
}