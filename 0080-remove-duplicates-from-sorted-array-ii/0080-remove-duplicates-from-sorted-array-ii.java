class Solution {
    public int removeDuplicates(int[] nums) {
        int last = nums[0];
        int count=0;

        int k=0;

        for(int i : nums){
            if(i == last && count<2){
                count++;
                nums[k++]=i;
            }else if(i!=last){
                count=1;
                last=i;
                nums[k++]=i;
            }
        }

        return k;
    }
}