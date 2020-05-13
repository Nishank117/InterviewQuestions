class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0 || s == null)
            return 0;
        if(s.length() == 1){
            return 1;
        }
        if(s.length() == 2){
            return s.charAt(0) == s.charAt(1) ? 3: 2;
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0;i<s.length();i++){
            dp[i][i] = 1;
        }
        
        for(int l = 2; l <= s.length(); l++){
            for(int i = 0; i < s.length()-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 1;
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                count+=dp[i][j];
            }
        }
        return count;
    }
}