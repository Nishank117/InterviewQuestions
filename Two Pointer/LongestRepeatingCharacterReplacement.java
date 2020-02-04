class Solution {
    public int characterReplacement(String s, int k) {
        
        int N = s.length();
        int[] char_counts = new int[26];
        int window_start = 0;
        int max_length = 0;
        //checks the max length till against which we need to make our operations
        int max_count = 0; 
        
        
        for(int window_end = 0;window_end<N;window_end++){
            //Incrementing to keep track of occurance of each character so that
            //we can know which character to replace in the sliding window 
            char_counts[s.charAt(window_end)-'A']++;
            max_count = Math.max(max_count,char_counts[s.charAt(window_end)-'A']);
            
            //It basically checks whether or not you can do a operation
            while(window_end - window_start - max_count + 1 > k){
                //the main aspect of sliding window is you add from the end and 
                // pop off from the front
                char_counts[s.charAt(window_start)-'A']--;
                // we are also diminishing the sliding window
                window_start++;
            }
            max_length = Math.max(max_length,window_end-window_start+1);
            
        }
        
        return max_length;
    }
    
}