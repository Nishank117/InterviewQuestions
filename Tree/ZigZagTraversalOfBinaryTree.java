/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> results;
    int resCount = 0;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        results = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode c = s1.pop();
                temp.add(c.val);
                if(c.left != null) s2.push(c.left);
                if(c.right != null) s2.push(c.right);
            }
            results.add(temp);
            temp = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode c = s2.pop();
                temp.add(c.val);
                if(c.right != null) s1.push(c.right);
                if(c.left != null) s1.push(c.left);
            }
            if(!temp.isEmpty()) results.add(temp);
        }
        return results;
    }
}