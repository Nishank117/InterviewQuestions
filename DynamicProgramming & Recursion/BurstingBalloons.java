class Solution {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length+2];
        for(int i = 0;i<iNums.length;i++){
            nums[i+1] = iNums[i];
            System.out.println(nums[i+1]);
        }
        
        nums[0] = nums[nums.length-1] = 1;
        int[][] dp = new int[nums.length][nums.length];
        for(int length = 2;length<nums.length;length++){
            for(int left = 0;left<nums.length-length;++left){
                int right = left+length;
                for(int j = left+1;j<right;++j){
                    dp[left][right] = Math.max(dp[left][right],nums[left]*nums[j]*nums[right]+dp[left][j]+dp[j][right]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}