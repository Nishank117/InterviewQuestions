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
    List<String> results;
    public List<String> binaryTreePaths(TreeNode root) {
        results = new ArrayList<>();
        if(root == null){
            return results;
        }
        String parentString = String.valueOf(root.val);
        DFS(root,parentString);
        return results;
    }
    
    public void DFS(TreeNode root,String parentString){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            results.add(parentString.toString());
            return;
        }
        parentString = parentString+"->";
        if(root.left != null){
            String resultantString = parentString+String.valueOf(root.left.val);
            DFS(root.left,resultantString);
        }
        if(root.right != null){
            String resultantString = parentString+String.valueOf(root.right.val);
            DFS(root.right,resultantString);
        }
        
    }
}