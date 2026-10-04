class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res=0;

        for(int i=0;i<n;i++){
            res+= expand(s,i,i);
            res+=expand(s,i,i+1);
        }
        return res;
    }

    int expand(String s , int left , int right){
        int res=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            res++;
            left--;
            right++;
        }
        return res;
    }
}