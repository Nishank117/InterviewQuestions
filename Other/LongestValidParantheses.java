import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//Stack Solution
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        Stack<Integer> stack  = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                result = Math.max(result,i-stack.peek());
            }
        }

        return result == Integer.MIN_VALUE? 0:result;
    }
}