class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int [] max = new int[n];
        int [] min = new int[n];

        int maxE = nums[0];
        int minE = nums[n-1];

        for(int i=0;i<n;i++){
            if(nums[i]> maxE) maxE = nums[i];
            max[i]=maxE;
        }

        for(int i=n-1;i>=0;i--){
            if(nums[i]<minE) minE=nums[i];
            min[i]=minE;
        }

        int idx =-1;

        for(int i=0;i<n;i++){
            if(max[i]-min[i] <=k){
                return i;
            }
        }

        return idx;
    }
}