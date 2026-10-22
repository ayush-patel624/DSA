class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res=0;
        long sum=0;
        int left=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];

            while((long) nums[i]*(i-left+1) - sum >k){
                sum-=nums[left];
                left++;
            }

            res=Math.max(res,i-left+1);
        }
        return res;
    }
}