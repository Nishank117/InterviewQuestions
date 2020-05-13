class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 0 || s == null)
            return 0;
        if(s.length() == 1){
            return 1;
        }
        if(s.length() == 2){
            return s.charAt(0) == s.charAt(1) ? 2: 1;
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0;i<s.length();i++){
            dp[i][i] = 1;
        }
        
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                 dp[i][i+1] = 2;
            }else{
                dp[i][i+1] = 1;
            }
        }
        for(int l = 2; l <= s.length(); l++){
            for(int i = 0; i < s.length()-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        
        return dp[0][s.length()-1];
    }
}