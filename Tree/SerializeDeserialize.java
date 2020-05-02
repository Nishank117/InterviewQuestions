class Solution {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
         System.out.println(sb.toString());
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    public TreeNode buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if(val.equals("null")){
            return null;
        }
        int rootVal = Integer.parseInt(val);       
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }
}