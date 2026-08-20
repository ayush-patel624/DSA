class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;

        int n = nums.length;
        if(sum%2!=0) return false;
        
        int target = sum/2;

        boolean [] dp = new boolean[target+1];
        Arrays.fill(dp,false);
        dp[0]= true;

        for(int i=0;i<n;i++){
            for(int j=target;j-nums[i]>=0;j--){
                dp[j]= dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}