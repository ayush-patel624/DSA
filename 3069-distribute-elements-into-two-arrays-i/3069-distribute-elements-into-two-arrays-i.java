class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int [] res = new int[n];

        int [] arr1 = new int[n];
        int [] arr2 = new int[n];

        arr1[0]=nums[0];
        arr2[0]=nums[1];

        int i=2;
        int last1 = 0;
        int last2 = 1;

        int idx1=1;
        int idx2=1;

        while(i<n){
            if(nums[last1]>nums[last2]){
                arr1[idx1++]=nums[i];
                last1=i;
            }else{
                arr2[idx2++]=nums[i];
                last2=i;
            }
            i++;
        }

        int j=0;
        int k=0;
        while(j<n && arr1[j]!=0){
            res[k++]=arr1[j++];
        }
        j=0;
        while(j<n && arr2[j]!=0){
            res[k++]=arr2[j++];
        }

        return res;

    }
}