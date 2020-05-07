class MagicDictionary {
    
    Map<String,List<StringNode>> dictMap;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        dictMap = new HashMap();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        //Building the dictionary starts with having all charAt i for a string
        //and create a StringNode using the i,wor.charAt(i) with the key for it being the remaining string
        for(String word : dict){
            for(int i = 0;i<word.length();i++){
                String key = word.substring(0,i)+word.substring(i+1);
                List<StringNode> sNodeList = dictMap.getOrDefault(key,new ArrayList<>());
                sNodeList.add(new StringNode(i,word.substring(i,i+1)));
                dictMap.put(key,sNodeList);
            }
        }
    }
    
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(Map.Entry<String,List<StringNode>> entry : dictMap.entrySet()){
            List<StringNode> list = entry.getValue();
            for(StringNode str:list){
                System.out.println("("+entry.getKey()+",("+str.val+","+str.str+"))");
            }
            
        }
        for(int i = 0;i<word.length();i++){
            String key = word.substring(0,i)+word.substring(i+1);
            
            if(dictMap.containsKey(key)){
                List<StringNode> sNodeList = dictMap.get(key);
                for(StringNode sNode:sNodeList){
                    //condition to check
                    //if !sNode.string.equals(s.charAt(i)) and sNode.val == i
                    //it makes sure that we don't overrun any conditions
                    if(!sNode.str.equals(word.substring(i,i+1)) && sNode.val == i){
                        System.out.println("true "+word);
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
class StringNode{
    int val;
    String str;
    StringNode(int val,String str){
        this.val = val;
        this.str= str;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */