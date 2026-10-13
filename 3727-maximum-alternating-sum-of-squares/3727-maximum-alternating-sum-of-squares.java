class Solution {
    public long maxAlternatingSum(int[] nums) {
        int [] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++) temp[i]=Math.abs(nums[i]);
        Arrays.sort(temp);
        long res =0;
        int low=0;
        int high=nums.length-1;

        while(low<high){
            res+= temp[high]*temp[high];
            res-=temp[low]*temp[low];
            low++;
            high--;
        }
        if(nums.length%2!=0) res+= temp[high]*temp[high];
        return res;
    }
}