import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int[] map = new int[128];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        int head = 0;
        int begin = 0;
        int end = 0;
        int counter = t.length();
        while(end<s.length()){
            int count = map[s.charAt(end)];
            if(count-- >0){
                counter--;
            }
            map[s.charAt(end)]--;
            end++;
            while(counter == 0){
                if(min>end-begin){
                    head = begin;
                    min = end-begin;
                }
                char c = s.charAt(begin);
                map[c]++;
                if(map[c] > 0){
                    counter++;
                }
                begin++;
            }

        }
        return min == Integer.MAX_VALUE?"":s.substring(head,head+min);
    }
}