class Solution {
    public int largestInteger(int[] nums, int k) {
        
        HashMap<Integer,Integer> count = new HashMap<>();
        
        int max=Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<nums.length;i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            max=Math.max(max,nums[i]);
        }

        int SingleMax=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(count.get(nums[i])==1) SingleMax = Math.max(SingleMax,nums[i]);
        }

        if(k==1) return SingleMax==Integer.MIN_VALUE ? -1 : SingleMax;
        else if (k==n) return max;
        else{
            int res=-1;
            if(count.get(nums[n-1])==1) res=Math.max(res,nums[n-1]);
            if(count.get(nums[0])==1) res=Math.max(res,nums[0]);

            return res;
        }

    }
}