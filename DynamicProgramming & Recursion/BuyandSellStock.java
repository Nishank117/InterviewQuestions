class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int length = prices.length;
        int[][] dp = new int[3][length];
        
        for(int i = 0;i<3;i++){
            int maxDiff = -prices[0];
            for(int j = 0;j<length;j++){
                if(i>0 && j>0){
                    dp[i][j] = Math.max(dp[i][j-1],prices[j]+maxDiff);
                    maxDiff = Math.max(maxDiff,dp[i-1][j]-prices[j]);
                }  
            }
        }
        return dp[2][length-1];
    }
}