class Solution {
    Map<String,Integer> count;
    List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        result = new ArrayList();
        buildString(root);
        return result;
    }
    
    private String buildString(TreeNode node) {
        if(node == null){ return "#";}
        else{
            String res = node.val+","+buildString(node.left)+","+buildString(node.right);
            count.put(res,count.getOrDefault(res,0)+1);
            if(count.get(res) == 2){
                result.add(node);
            }
            return res;
        }
    }
}
//Second Solution using hashes to lookup 

// Suppose we have a unique identifier for subtrees: two subtrees are the same if and only if they have the same id.
// Then, for a node with left child id of x and right child id of y, (node.val, x, y) uniquely determines the tree.

// If we have seen the triple (node.val, x, y) before, we can use the identifier we've remembered. Otherwise, we'll create a new one.


class Solution {
    int t;
    Map<Integer,Integer> count;
    Map<String,Integer> trees;
    List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        count = new HashMap<>();
        trees = new HashMap<>();
        result = new ArrayList();
        lookUp(root);
        return result;
    }
    
    private int lookUp(TreeNode node) {
        if(node == null){ return 0;}
        else{
            String res = node.val+","+lookUp(node.left)+","+lookUp(node.right);
            int uid = trees.computeIfAbsent(res,k->t++);
            count.put(uid,count.getOrDefault(uid,0)+1);
            if(count.get(uid) == 2){
                result.add(node);
            }
            return uid;
        }
    }
}