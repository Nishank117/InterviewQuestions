// I hope this helps those folks who can't figure out how to get the index of the right child:

// Our aim is to find out the index of right child for current node in the preorder array
// We know the index of current node in the preorder array - preStart (or whatever your call it), it's the root of a subtree
// Remember pre order traversal always visit all the node on left branch before going to the right ( root -> left -> ... -> right), therefore, we can get the immediate right child index by skipping all the node on the left branches/subtrees of current node
// The inorder array has this information exactly. Remember when we found the root in "inorder" array we immediately know how many nodes are on the left subtree and how many are on the right subtree
// Therefore the immediate right child index is preStart + numsOnLeft + 1 (remember in preorder traversal array root is always ahead of children nodes but you don't know which one is the left child which one is the right, and this is why we need inorder array)
// numsOnLeft = root - inStart.

class Solution {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if(preOrder.length == 0||inOrder.length == 0){
            return null;
        }
        return helper(0,0,preOrder.length,preOrder,inOrder);
    }
    
    public TreeNode helper(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        if(inStart>inEnd || preStart>=inorder.length){
            return null;
        }
        TreeNode head = new TreeNode(preorder[preStart]);
        int i = 0;
        for(i = inStart;i<inEnd;i++){
            if(inorder[i]==head.val){
                break;
            }
        }
        head.left = helper(preStart+1,inStart,i-1,preorder,inorder);
        head.right = helper(preStart+i-inStart+1,i+1,inEnd,preorder,inorder);
            
        return head;
    }
}