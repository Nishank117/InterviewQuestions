class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null){
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //to tackle cases like a*b*c*
        for(int i = 1;i<p.length()+1;i++){
            if(i>1 && p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i = 1;i<s.length()+1;i++){
            for(int j = 1;j<p.length()+1;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    //get the diagonally above value
                    dp[i][j] = dp[i-1][j-1];
                }else if(j>=2 && p.charAt(j-1) == '*'){
                    //checking zero occurance of character.
                    dp[i][j] = dp[i][j-2];
                    //we also check for these cases
                    if(p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}