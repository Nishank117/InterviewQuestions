class Solution {
    public int longestOnes(int[] A, int K) {
        int N = A.length;
        int window_start = 0;
        int window_end = 0;
        int max_length = 0;
        
        for(window_end = 0;window_end<N;window_end++){
            //we decrement K untill it is negative
            if(A[window_end] == 0){
                K--;
            }
            //if K is negative we find other zero untill that we increment the start pointer
            while(K<0){
                
                if(A[window_start++] == 0){
                    K++;
                }
            }
            max_length = Math.max(max_length,window_end-window_start+1); 
        }
        return max_length;
    }
}