//so this is how you break your problems into subproblems
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        //Since there is only way you can reach the element on the top vertical row since 
        //the problem says that you can only move down and to your right
        for(int i =0 ;i<n;i++){
            dp[i][0] = 1;
        }
        //similarly one way to reach the left most elements
        for(int i =0 ;i<m;i++){
            dp[0][i] = 1;
        }
        //for example you need to find the number of ways to go to 
        //dp[1][1] = it could be you go right once and go down from dp[0][0]
        //or you can go below and then right from dp[0][0] which 
        //means it is dp[1][1] = dp[1][0]+dp[0][1];ß
        for(int i =1 ;i<n;i++){
            for(int j = 1;j<m;j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        
        return dp[n-1][m-1];
    }
}