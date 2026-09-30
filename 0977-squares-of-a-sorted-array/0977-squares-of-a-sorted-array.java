class Solution {
    public int[] sortedSquares(int[] nums) {
        int pos =0;
        int n = nums.length;
        int idx=0;
        int [] res = new int[n];

        while(pos<n && nums[pos]<0) pos++;

        int neg=pos-1;

        while(neg>=0 && pos<n){
            if(Math.abs(nums[pos]) < Math.abs(nums[neg])){
                res[idx++]= nums[pos]*nums[pos];
                pos++;
            }else{
                res[idx++]=nums[neg]*nums[neg];
                neg--;
            }
        }

        while(neg>=0){        
            res[idx++]=nums[neg]*nums[neg];
            neg--;
        }

         while(pos<n){        
            res[idx++]=nums[pos]*nums[pos];
            pos++;
        }

        return res;
    }
}