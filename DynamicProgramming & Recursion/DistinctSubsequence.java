class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 1;
        for(int i = 1;i<=s.length();i++){
            dp[i][0] = 1;
        }
        //dp[i+1][j+1] shows that s[0..i] contains dp[i+1][j+1] subsequences
        //that form t[0..j]
        for(int i = 0;i<s.length();i++){
            for(int j = 0;j<t.length();j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+dp[i][j+1];
                }else{
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}