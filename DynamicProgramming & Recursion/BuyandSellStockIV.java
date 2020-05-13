class Solution {
    //it is same as solving the Buy and Sell of stock with k transactions
    //but if the number of transactions is greater than equal to length/2 
    // we have a quick solve method

    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int length = prices.length;
        if(k>=length/2) return quickSolve(prices);
        int[][] dp = new int[k+1][length];
        
        for(int i = 0;i<k+1;i++){//here i denotes number of transactions
            int maxDiff = -prices[0];
            for(int j = 0;j<length;j++){//here j means the days
                if(i>0 && j>0){
                    //slower method would be to 
                    //create a loop and find max(dp[i][j-1],prices[j]-prices[m]+dp[i-1][m])
                    //where m -> 0 to j-1 
                    dp[i][j] = Math.max(dp[i][j-1],prices[j]+maxDiff);
                    maxDiff = Math.max(maxDiff,dp[i-1][j]-prices[j]);
                }  
            }
        }
        return dp[k][length-1];
    }
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}