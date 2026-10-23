class Solution {
    public int sortPermutation(int[] nums) {
        int [] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        int res=-1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(temp[i]!=nums[i]) res = res&nums[i];
        }
        return res==-1 ? 0: res;
    }
}