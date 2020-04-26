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
    List<List<Integer>> results;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        results = new ArrayList<>();
        if(root == null){
            return results;
        }
        List<Integer> parentList = new ArrayList<>();
        DFS(root,sum,parentList);
        
        return results;
    }
    public void DFS(TreeNode root,int sum,List<Integer> parentList){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && sum == root.val){
            parentList.add(root.val);
            results.add(new ArrayList<>(parentList));
            parentList.remove(parentList.size()-1);
            return;
        }else{
            sum = sum-root.val;
            parentList.add(root.val);
            DFS(root.left,sum,parentList);
            DFS(root.right,sum,parentList);
            parentList.remove(parentList.size()-1);
        }
        
        
    }
}