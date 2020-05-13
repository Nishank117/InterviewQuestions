class Solution {
    //basically king of recursion must do question
    //the solution is intuitive
    public List<TreeNode> generateTrees(int n) {
        if(n<1){
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }
    private List<TreeNode> generateTrees(int low,int high){
        List<TreeNode> result = new ArrayList<>();
        if(low>high){
            result.add(null);
            return result;
        }
        for(int i = low;i<=high;i++){
            List<TreeNode> leftSubTrees = generateTrees(low,i-1);
            List<TreeNode> rightSubtrees = generateTrees(i+1,high);
            for(TreeNode leftSubTree:leftSubTrees){
                for(TreeNode rightSubtree:rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubtree;
                    result.add(root);
                }
            }
        }
        return result;
    }
    
}