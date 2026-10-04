class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        if(n==1) return 0;

        int low=0;
        while(low <n && s.charAt(low)=='0') low++;

        int high=low+1;

        long res=0;

        while(high<n){
            if(s.charAt(high)=='0') {
                res+=high-low;
                high++;
                low++;
            }else{
                high++;
            }
        }

        return res;

    }
}