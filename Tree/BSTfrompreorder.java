class Solution {
    //Solve the inorder and preorder to binary tree first
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode head = bstFromPreorder(preorder,0,preorder.length-1);
        
        return head;
    }
    
    private TreeNode bstFromPreorder(int[] preorder,int start,int end){
    
        if(start>end || start < 0 || end >= preorder.length){
            return null;
        }
        TreeNode head = new TreeNode(preorder[start]);
        
        int i;
        for(i = start;i<=end;i++){
            if(preorder[i]>preorder[start]){
                break;
            }
        }
        
        head.left = bstFromPreorder(preorder,start+1,i-1);
        head.right = bstFromPreorder(preorder,i,end);
        
        return head;
        
    }
}