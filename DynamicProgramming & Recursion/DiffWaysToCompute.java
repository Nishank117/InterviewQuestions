class Solution {
    //same as unique binary search trees II
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> result = new ArrayList<>();
        for(int k = 0;k<input.length();k++){
            //recurse when you find an operator
            if(input.charAt(k) == '*'||input.charAt(k) == '-'||input.charAt(k) == '/'||input.charAt(k) == '+'){
                List<Integer> left = diffWaysToCompute(input.substring(0,k));
                List<Integer> right = diffWaysToCompute(input.substring(k+1));
                int output = 0;
                for(int i: left){
                    for(int j: right){
                        if(input.charAt(k) == '+'){
                            output = i+j;
                            result.add(output);
                            continue;
                        }
                        if(input.charAt(k) == '*') {
                            output = i*j;
                            result.add(output);
                            continue;
                        }
                        if(input.charAt(k) == '/') {
                            output = i/j;
                            result.add(output);
                            continue;
                        }
                        if(input.charAt(k) == '-') {
                            output = i-j;
                            result.add(output);
                            continue;
                        }


                    }
                }
            }
            
          
        }
        if(result.size() == 0){
            result.add(Integer.valueOf(input));
        }
        return result;  
    }
}