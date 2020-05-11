class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int missingPositive = 1;
        for(int i = 0;i<set.size();i++){
            if(!set.contains(missingPositive)){
                return missingPositive;
            }else{
                missingPositive++;
            }
        }
        return missingPositive;
    }
}