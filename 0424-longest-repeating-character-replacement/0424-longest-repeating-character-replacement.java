class Solution {
    int findMax(int [] arr){
        int res =Integer.MIN_VALUE;
        for(int i : arr) res=Math.max(res,i);
        return res;
    }
    public int characterReplacement(String s, int k) {
        int res=0;
        int low=0;
        int high=0;

        int [] arr = new int[65];

        while(high<s.length()){
            char c = s.charAt(high);
            arr[(int)c - 65]++;

            int max = findMax(arr);
            
            int len = high-low+1;
            int rem = len-max;

            while(rem>k){
                char y = s.charAt(low);
                arr[(int)y-65]--;

                max=findMax(arr);

                low++;

                len = high-low+1;
                rem = len-max;
            }

            len = high-low+1;
            res=Math.max(res,len);
            high++;
        }

        return res;
    }
}