class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int currSum = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            currSum +=nums[i];
            if(currSum == k){
                count++;
            }
            if(map.containsKey(currSum - k)){
                count+=map.get(currSum-k);
            }
            
            int value = map.getOrDefault(currSum,0);
            map.put(currSum,value+1);
        }
        
        
        return count;
    }
}