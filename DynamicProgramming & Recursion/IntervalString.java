class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        if(s1.length() == 0){
            if(s2.length() != 0){
                return s2.equals(s3);
            }
        }
        if(s2.length() == 0){
            if(s1.length() != 0){
                return s1.equals(s3);
            }
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1;i<s1.length()+1;i++){
            if(s3.charAt(i-1) == s1.charAt(i-1)){
                dp[i][0] = dp[i-1][0];
            }else{
                dp[i][0] = false;
            }
        }
        for(int i = 1;i<s2.length()+1;i++){
            if(s3.charAt(i-1) == s2.charAt(i-1)){
                dp[0][i] = dp[0][i-1];
            }else{
                dp[0][i] = false;
            }
        }
        //main logic
        //dp[i][j] == checks if i+j-1th character equals to i-1th character in s1 && dp[i-1][j]
        //or equals to i-1th character in s1 && dp[i][j-1] 
        for(int i = 1;i<s1.length()+1;i++){
            for(int j = 1;j<s2.length()+1;j++){
                //remember to or the value
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) 
                            || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}