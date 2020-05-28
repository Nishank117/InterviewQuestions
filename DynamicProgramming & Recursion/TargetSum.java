
class Solution {
    Map<String,Integer> map;
    public int findTargetSumWays(int[] nums, int S) {
        map = new HashMap<>();
        return generateAllPermutations(nums,0,0,S);
    }
    private int generateAllPermutations(int[] nums,int index,int eval,int target){
        String curr = index+"->"+eval;
        if(map.containsKey(curr)){
            return map.get(curr);
        }
        if(index == nums.length && target == eval){
            count++;
            return 1;
        }
        if(index >= nums.length){
            return 0;
        }
        int positive = generateAllPermutations(nums,index+1,eval+nums[index],target);
        int negative = generateAllPermutations(nums,index+1,eval-nums[index],target);
        map.put(curr,positive+negative);
        return positive+negative;
    }
}
