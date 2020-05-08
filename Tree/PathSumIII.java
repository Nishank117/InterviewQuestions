class Solution {
    int count;
    Map<Integer,Integer> preSum;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        count = 0;
        preSum = new HashMap<Integer,Integer>();
        preSum.put(0,1);
        DFS(root,0,sum);
        return count;
    }
    public void DFS(TreeNode root,int currSum,int target){
        if(root == null){
            return;
        }
        //calculating the prefix sum
        currSum += root.val;
        if(preSum.containsKey(currSum-target)){
            count+=preSum.get(currSum-target);
        }        
        preSum.put(currSum,preSum.getOrDefault(currSum,0)+1);
        DFS(root.right,currSum,target);
        DFS(root.left,currSum,target);
        preSum.put(currSum,preSum.get(currSum)-1);
    }
}