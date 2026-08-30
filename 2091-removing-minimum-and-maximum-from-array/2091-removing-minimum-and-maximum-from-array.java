class Solution {
    public int minimumDeletions(int[] nums) {
        int min=nums[0];
        int max=nums[0];

        int minPos =0;
        int maxPos=0;

        int n = nums.length;

        if(n==1) return 1;

        for(int i=1;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
                minPos =i;
            }
            if(nums[i]>max){
                max=nums[i];
                maxPos=i;
            }
        }

        int c1 = minPos > maxPos ? minPos+1 : maxPos+1;
        int c2 = minPos < maxPos ? n-minPos : n-maxPos;
        int c3 = minPos < maxPos ? minPos+1 + (n-maxPos) : maxPos+1 + (n-minPos);

        return Math.min(c1,Math.min(c2,c3));
    }
}