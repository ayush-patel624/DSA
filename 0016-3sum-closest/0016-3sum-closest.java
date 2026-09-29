class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res =Integer.MAX_VALUE;
        int n = nums.length;
        int diff = Integer.MAX_VALUE;


        Arrays.sort(nums);

        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right = n-1;
            int sum =0;

            while(left<right){
                sum = nums[i]+nums[left]+nums[right];

                if(sum==target) return sum;
                if(sum<target){
                    left++;
                }else{
                    right--;
                }

                if(Math.abs(sum-target)<diff){
                    diff = Math.abs(sum-target);
                    res=sum;
                }
            }

        }

        return res;
    }
}