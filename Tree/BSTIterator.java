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
class BSTIterator {
    List<Integer> nodeList;
    int count;
    public BSTIterator(TreeNode root) {
        count = 0;
        nodeList = new ArrayList<>();
        inorder(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        if(hasNext()){
            int next = nodeList.get(count);
            count++;
            return next;
        }
        return -1;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return count < nodeList.size();
    }
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        nodeList.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */