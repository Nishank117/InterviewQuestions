class Solution {
    //the idea to solve this question is find the maximum square ending at 
    //dp[row][col]
    //so if dp[row][col] == 1 and it's neighbor vertically above , left and diagonally above
    //we take their mins and add to dp[row][col]
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix == null){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        for(int i = 1;i<n;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
        }
        
        for(int i = 1;i<m;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
            }
        }
        int answer = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1;//we assign 1 regardless of what it's neighbors are
                    //this conditions takes care of top row and vertically left column
                    if(i>0 && j>0){
                        dp[i][j] += Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    }
                    answer = Math.max(answer,dp[i][j]);
                }
            }
        }
        
        return answer*answer;
    }
}