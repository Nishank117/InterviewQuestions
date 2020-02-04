/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        inorder(root);
        return root.val;
    }
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        inorder(root.right);
        root.val+=get(root.left)+get(root.right);
        root.val = Math.max(root.val,get(root));
    }
    public int get(TreeNode root){
        if(root == null){
            return 0;
        }
        int count = 0;
        count += root.left==null?0:root.left.val;
        count += root.right==null?0:root.right.val;
        
        return count;
    }
}
