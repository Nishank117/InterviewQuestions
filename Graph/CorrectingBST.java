class GfG
{
    void inorderx(Node root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inorderx(root.left,list);
        list.add(root.data);
        inorderx(root.right,list);
    }
    static int index;
    void inorderUpdate(Node root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inorderUpdate(root.left,list);
        root.data = list.get(index);
        ++index;
        //System.out.print(index+" ");
        inorderUpdate(root.right,list);
    }
    public Node correctBST(Node root)
    {
        // Your code here
        if(root == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        inorderx(root,list);
        Collections.sort(list);
        //System.out.println(list);
        index = 0;
        inorderUpdate(root,list);
        return root;
        
    }
    
}
