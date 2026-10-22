class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n =nums.length;
        int res=0;
        int high=0;
        int low=0;

        while(high<n){
            while(nums[high]-nums[low]>2*k){
                low++;
            }
            res=Math.max(res,high-low+1);
            high++;
        }
        return res;
    }
}