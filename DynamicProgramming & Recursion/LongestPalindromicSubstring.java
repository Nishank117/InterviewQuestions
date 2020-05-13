class LongestPalindromicSubstring {
    public String printSubStr(String str, int low, int high) { 
        return str.substring(low, high + 1); 
    } 
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dpArray = new boolean[length][length];
        int maxLength = 0;
        int start = 0;
        //length one palindromes
        for(int i = 0;i<length;i++){
            dpArray[i][i] = true;
            start = i; 
            maxLength = 1; 
        }
        //length two palindromes
        for(int i = 0;i<length-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dpArray[i][i+1] = true;
                start = i; 
                maxLength = 2; 
            }
        }
        
        //check for palindromes greater than size 3
        for(int k = 3;k<=length;k++){
            //set the initial index 
            for(int i = 0;i<length-k+1;i++){
                // Get the ending index of substring from 
                // starting index i and length k 
                int j = i+k-1;
                // checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome
                if(s.charAt(i) == s.charAt(j) && dpArray[i+1][j-1] ){
                    dpArray[i][j] = true;
                    if(maxLength<k){
                        maxLength = k;
                        start = i;
                        //System.out.println(k+" "+start+" "+ start+k);
                    }
                } 
            }
        }
       return  printSubStr(s,start,start+maxLength-1);
    }
}