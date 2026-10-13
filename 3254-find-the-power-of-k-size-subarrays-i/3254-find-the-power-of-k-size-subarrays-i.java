class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if(k==1) return nums;
        int [] res = new int[n-k+1];

        int low=0;
        int high=0;

        for(int i=0;i<n-k+1;i++){
            int j = i+1;
            while(j<i+k && nums[j-1]+1==nums[j]){
                j++;
            }
            if(j==i+k) res[i]=nums[j-1];
            else res[i]=-1;
        }

        return res;
    }
}