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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.size() != 0){
            TreeNode curr = stack.pop();
            if(curr != null){
                result.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        
        return result;
    }
}