class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int low=0;
        int high=0;

        int sum=0;

        if(target==0) return 0;

        while(high<nums.length){
            sum+=nums[high];

            while(sum>=target){
                if(high-low+1 < res){
                    res=high-low+1;
                }
                sum-=nums[low];
                low++;
            }

            high++;
        }

        return res==Integer.MAX_VALUE ? 0 : res;
    }
}