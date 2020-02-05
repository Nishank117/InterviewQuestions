class Solution{
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) {
           return "";
       }
       if (nums.length == 1) {
           return nums[0] + "";
       }
       if (nums.length == 2) {
           return nums[0] + "/" + nums[1];
       }
       StringBuilder s = new StringBuilder();
       s.append(nums[0] + "/(" + nums[1]);
       for (int i = 2; i < nums.length; i++) {
           s.append("/");
           s.append(nums[i]);
       }
       s.append(")");
       return s.toString(); 
    }
}