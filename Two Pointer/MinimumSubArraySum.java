class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int min_Length = Integer.MAX_VALUE;
        int running_sum = 0;
        for(int i = 0,j=0;i<n;i++){
            running_sum += nums[i];
            while(running_sum>=s){
                min_Length = Math.min(min_Length,i-j+1);
                running_sum -= nums[j];
                j++;
            }
            
        }
        return min_Length == Integer.MAX_VALUE?0:min_Length;
    }
}