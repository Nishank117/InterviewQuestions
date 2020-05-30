import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public String countOfAtoms(String formula) {
        int N = formula.length();
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());
        for(int i = 0;i<N;){
            if(formula.charAt(i) == '('){
                stack.push(new TreeMap<>());
                ++i;
            }else if(formula.charAt(i) == ')'){
                Map<String, Integer> top = stack.pop();
                int iStart = ++i;
                int multiplicity = 1;
                while(i<N && Character.isDigit(formula.charAt(i))) ++i;
                if(i>iStart) multiplicity = Integer.parseInt(formula.substring(iStart,i));
                for(String c:top.keySet()){
                    int count = top.get(c);
                    stack.peek().put(c,stack.peek().getOrDefault(c,0)+count*multiplicity);
                }
            }else{
                int iStart = i++;
                //Example Mg firstly i is at M
                //we assign iStart to M and increment i
                //to get the full chemical name of Mg 
                while(i<N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart,i);
                iStart = i;
                while(i<N && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = i>iStart?Integer.parseInt(formula.substring(iStart,i)):1;
                stack.peek().put(name,stack.peek().getOrDefault(name,0)+multiplicity);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1) ans.append("" + multiplicity);
        }
        return new String(ans);
    }
}