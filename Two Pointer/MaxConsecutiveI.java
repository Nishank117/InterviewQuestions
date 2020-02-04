class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int N = nums.length;
        int max_length = 0;
        int window_start = 0;
        int count = 0;
        for(int window_end = 0;window_end<N;window_end++){
            
            if(nums[window_end] == 1){
                ++count;
            }else{
                window_start = window_end+1;
                count = 0;
            }
            max_length = Math.max(max_length,count);
        }
        return max_length;
    }
}