class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];

        dp[0]=1;
        dp[1] = s.charAt(0)=='0' ? 0 : 1 ;

        for(int i=2;i<=n;i++){
            int c = s.charAt(i-1) - '0';

            if(c>=1 && c<=9){
                dp[i]+=dp[i-1];
            }

            int c2 = Integer.parseInt(s.substring(i-2,i));

            if(c2>=10 && c2<=26){
                dp[i]+=dp[i-2];
            }
        }

        return dp[n];
        
    }
}