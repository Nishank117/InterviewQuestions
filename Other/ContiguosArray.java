class Solution {
    //Idea is to keep a count 
    //if nums[i] == 0 decrement else increment
    //so we have a map which stores the initial occurance of any count value
    //so maxLen = max of previous maxLen and i-map.get(count)
    //remember initially to put(0,-1) in the map

    public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums.length == 1 || nums == null){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        int count = 0;
        map.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                count--;
            }else{
                count++;
            }
            if(!map.containsKey(count)){
                map.put(count,i);
            }else{
                maxLen = Math.max(maxLen,i-map.get(count));
            }
        }
        
        return maxLen;
    }
}