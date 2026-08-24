class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];

        for(int i=1;i<prices.length;i++){
            res=Math.max(prices[i]-min , res);
            min=Math.min(min,prices[i]);
        }

        return res;
    }

}