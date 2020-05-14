class Solution {
    List<String> results;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0){
            return new ArrayList<>();
        }
        results = new ArrayList<>();
        generateAllCombinations(num,target,"",0,0,0);
        
        return results;
    }
    
    private void generateAllCombinations(String num,int target,String list,int index,long eval,long multifactor){
        if(index == num.length() && target == eval){
            results.add(list);
            return;
        }else{
            for(int i = index;i<num.length();i++){
                // tackles the case for "001"
                if(i != index && num.charAt(index) == '0') break;
                //adds the cases of multilength strings
                long current = Long.parseLong(num.substring(index,i+1));
                if(index == 0){
                    //for index = 0 we just pass on the current value at Oth index
                    generateAllCombinations(num,target,list+current,i+1,current,current);
                }else{
                    
                    generateAllCombinations(num,target,list+"+"+current,i+1,eval+current,current);
                    generateAllCombinations(num,target,list+"-"+current,i+1,eval-current,-current);
                    //the trick to solve multiplication
                    generateAllCombinations(num,target,list+"*"+current,i+1,eval-multifactor+multifactor*current,multifactor*current);

                }
            }
        }        
        
    }
}