class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(sumOfDigit(nums[i])==i) return i;
        }
        return -1;
    }

    int sumOfDigit(int n){
        int res=0;

        while(n>0){
            res += n%10;
            n=n/10;
        }

        return res;
    }
}