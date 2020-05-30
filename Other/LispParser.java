import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Must do recursion question
// the recursion is easy but the implementation is tough.
class Solution {
    public int evaluate(String expression) {
        return evaluate(expression,new HashMap<>());
    }
    private int evaluate(String expr, Map<String,Integer> parent){
        if(expr.charAt(0) != '('){
            if(Character.isDigit(expr.charAt(0)) || expr.charAt(0) == '-'){
                return Integer.parseInt(expr);
            }
            return parent.get(expr);
        }
        Map<String, Integer> map = new HashMap<>();
        map.putAll(parent);
        List<String> tokens = parse(expr.substring(expr.charAt(1) == 'm'?6:5,expr.length()-1));
        System.out.println(tokens.toString());
        if(expr.startsWith("(a")){
            return evaluate(tokens.get(0),map)+evaluate(tokens.get(1),map);
        }else if(expr.startsWith("(m")){
            return evaluate(tokens.get(0),map)*evaluate(tokens.get(1),map);
        }else{
            for(int i = 0;i<tokens.size()-2;i+=2){
                System.out.println(tokens.get(i)+" : "+evaluate(tokens.get(i+1),map));
                map.put(tokens.get(i),evaluate(tokens.get(i+1),map));
            }
            System.out.println(evaluate(tokens.get(tokens.size()-1),map));
            return evaluate(tokens.get(tokens.size()-1),map);
        }
    }
    private List<String> parse(String expr){
        List<String> res = new ArrayList<>();
        int par = 0;
        StringBuilder sb = new StringBuilder();
        for(char c:expr.toCharArray()){
            if(c == '(') par++;
            if(c == ')') par--;
            if(par == 0 && c == ' '){
                res.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        if (sb.length() > 0) res.add(new String(sb));
        return res;
    }
}