class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res=0;
        int low=0;
        int high=0;
        HashSet<Integer> set = new HashSet<>();
        long sum=0;

        while(high<n){
            while(high-low+1 <= k && high<n && !set.contains(nums[high])){
                set.add(nums[high]);
                sum+=nums[high];
                high++;
            }
            if(high-low+1 == k+1 ) res=Math.max(res,sum);
            sum-=nums[low];
            set.remove(nums[low]);
            low++;
        }
        return res;
    }
}