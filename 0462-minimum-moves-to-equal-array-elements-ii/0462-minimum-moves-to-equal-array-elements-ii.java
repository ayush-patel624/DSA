class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median=0;
        if(n==1) return 0;
        if(n==2) return Math.abs(nums[0]-nums[1]);
        if(n%2==0){
            int sum = nums[n/2-1] + nums[n/2];
            median = sum/2;
        }else{
            median = nums[n/2];
        }

        int res=0;

        for(int i : nums) res+=Math.abs(median-i);

        return res;
    }
}