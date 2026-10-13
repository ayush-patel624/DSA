class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n =nums.length;
        double sum=0;
        double res=Double.MIN_VALUE;

        int low=0;
        int high=k-1;

        for(int i=low;i<=high;i++) sum+=nums[i];
        res = sum/(double)k;

        while(high<n){
            sum-=nums[low];
            low++;
            high++;
            if(high<n)sum+=nums[high];
            if(high<n)res=Math.max(res,sum/(double)k);
        }

        return res;
    }
}