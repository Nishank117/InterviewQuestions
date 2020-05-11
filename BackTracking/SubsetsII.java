class Solution {
    List<List<Integer>> result;
    Set<List<Integer>> dupCheck;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        dupCheck = new HashSet<>();
        Arrays.sort(nums);
        generateAllSubSets(nums,new ArrayList<>(),0);
        return result;
    }
    private void generateAllSubSets(int[] nums,List<Integer> current,int start){
        //we add a copy of the current ArrayList;
        //so that we can have the current list added and reuse it again
        //same as subsets just added a set to check all the duplicate sets.
        if(!dupCheck.contains(current)){
            result.add(new ArrayList<>(current));
            dupCheck.add(current);
        //reuse part and adding new element to the ArrayList
            for(int i = start;i<nums.length;i++){
                //firstly we add it 
                current.add(nums[i]);
                //generate all the subsets from adding it like initially current = [0]
                //after going into the dfs we will have [0,1] then [0,2];
                //similarly we will be having it for all the numbers
                generateAllSubSets(nums,current,i+1);
                current.remove(current.size()-1);
            }
        }
        
    }
    
}