class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int [][] dp = new int[n][m];

        dp[0][0] = s.charAt(0)==t.charAt(0) ? 1 : 0 ;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];

            if (s.charAt(i) == t.charAt(0)) {
                dp[i][0]++;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]= dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        return dp[n-1][m-1];
    }
}