class Solution{
    private static int globalMaximum;
    public static int findPathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //ignoring the negative paths
        int left = Math.max(findPathSum(root.left),0);
        int right = Math.max(findPathSum(root.right),0);
        int localMaximum = left+right+root.val;
        globalMaximum = Math.max(localMaximum,globalMaximum);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        globalMaximum = Integer.MIN_VALUE;
        findPathSum(root);
        return globalMaximum;
    }
}