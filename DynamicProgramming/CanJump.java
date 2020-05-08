class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        //recursive way
        return canJump(nums,0);
        -----------------------------
        //dynamic programming way
        boolean[] dp = new boolean[nums.length];
        int n = nums.length;
        dp[n-1] = true;
        int lastTrue = n-1;
        for(int i = n-2;i>=0;i--){
            if(nums[i]>=lastTrue-i){
                dp[i] = true;
                lastTrue = i;
            }
        }
        
        return dp[0];
    }
    public boolean canJump(int[] nums,int x){
        if(x == nums.length-1){
            return true;
        }
        if(x >= nums.length){
            return false;
        }
        if(nums[x] == 0){
            return false;
        }
        boolean canJump = false;
        for(int i = 1;i<=nums[x];i++){
            canJump |= canJump(nums,x+i);
        }
        return canJump;
    }
}