class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m+1][n+1];

        int l = strs.length;
        
        for(int i=0;i<l;i++){
            int zeroC =0;
            int oneC =0;

            for(int j=0;j<strs[i].length();j++){
                char c = strs[i].charAt(j);
                if(c=='0') zeroC++;
                else oneC++;
            }

            for(int k=m;k>=zeroC;k--){
                for(int p=n;p>=oneC;p--){
                    dp[k][p] = Math.max(dp[k][p],dp[k-zeroC][p-oneC]+1);
                }
            }

        }

        int res=0;

        for(int i=0;i<=m;i++){
            res=Math.max(res,dp[i][n]);
        }

        return res;
    }
}