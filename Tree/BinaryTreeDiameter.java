class QueueNode{
    TreeNode node;
    int depth;
    QueueNode(TreeNode node,int depth){
        this.node = node;
        this.depth = depth;
    }
}
class Solution {
    int leftTreeLeaf;
    int rightTreeLeaf;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        Queue<QueueNode> leftqueue = new LinkedList<>();
        
        Queue<QueueNode> rightqueue = new LinkedList<>();
        if(root.left != null){
             leftqueue.add(new QueueNode(root.left,1));
        
            while(leftqueue.size() != 0){
                QueueNode curr = leftqueue.poll();
                leftDepth = Math.max(curr.depth,leftDepth);
                TreeNode node = curr.node;
                if(curr.node.left != null){
                    leftqueue.add(new QueueNode(curr.node.left,curr.depth+1));
                }
                if(curr.node.right != null){
                    leftqueue.add(new QueueNode(curr.node.right,curr.depth+1));
                }
            }
        }
       
        if(root.right != null){
            rightqueue.add(new QueueNode(root.right,1));
            while(rightqueue.size() != 0){
                QueueNode curr = rightqueue.poll();
                rightDepth = Math.max(curr.depth,rightDepth);
                TreeNode node = curr.node;
                if(curr.node.left != null){
                    rightqueue.add(new QueueNode(curr.node.left,curr.depth+1));
                }
                if(curr.node.right != null){
                    rightqueue.add(new QueueNode(curr.node.right,curr.depth+1));
                }
            }
        }
        
        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);
        
        System.out.println(leftDiameter+" "+rightDiameter);
        
        return Math.max(leftDepth+rightDepth,Math.max(leftDiameter,rightDiameter));
    }
    
    private int findDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        
        int leftheight = findHeight(root.left,1);
        int rightheight = findHeight(root.right,1);
        
        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);
        
        return Math.max(leftheight + rightheight,Math.max(leftDiameter,rightDiameter));
    }
    private int findHeight(TreeNode root,int height){
        if(root == null){
            return height;
        }
        if(root.left == null&&root.right == null){
            return height;
        }
        return Math.max(findHeight(root.left,height+1),findHeight(root.right,height+1));
    }

}