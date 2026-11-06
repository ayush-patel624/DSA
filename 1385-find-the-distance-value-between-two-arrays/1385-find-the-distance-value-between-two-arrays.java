class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res=0;

        for(int i : arr1){
            int found=0;

            for(int j : arr2){
                if(Math.abs(i-j)<=d){
                    found=1;
                    break;
                }
            }
            if(found==0) res+=1;
        }

        return res;
    }
}