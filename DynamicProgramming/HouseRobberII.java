class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int firstPath = calculate(nums,0,nums.length-1);
        int secondPath = calculate(nums,1,nums.length);
        
        return Math.max(firstPath,secondPath);
    }
    public int calculate(int[] nums,int i,int j){
        int inclusive = nums[i];
        int exclusive = 0;
        for(int k = i+1;k<j;k++){
            int temp = inclusive;
            inclusive = Math.max(exclusive+nums[k],inclusive);
            exclusive = temp;
        }
        return Math.max(inclusive,exclusive);
    }
}