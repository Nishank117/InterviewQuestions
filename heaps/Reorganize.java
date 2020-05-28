import java.util.*;
class Solution {
    public String reorganizeString(String S) {
        int N = S.length();
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c:S.toCharArray()){
            int count = charMap.getOrDefault(c,0)+1;
            System.out.println(count);
            if(count > (N+1)/2) return "";
            charMap.put(c,count);
        }
        PriorityQueue<Entry> queue = new PriorityQueue<>(((o1, o2) -> o2.count-o1.count));
        for(Map.Entry<Character,Integer> entry:charMap.entrySet()){
            queue.offer(new Entry(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            Entry first = queue.poll();
            if(sb.length() == 0 || first.c != sb.charAt(sb.length()-1)){
                int count = first.count;
                sb.append(first.c);
                if(--count>0){
                    queue.add(new Entry(first.c,count));
                }
            }else{
                Entry second = queue.poll();
                sb.append(second.c);
                if(--second.count>0){
                    queue.add(new Entry(second.c,second.count));
                }
                queue.add(first);
            }
        }
        String finalString = sb.toString();
        return finalString;
    }
}
class Entry{
    char c;
    int count;
    Entry(char c,int count){
        this.c = c;
        this.count = count;
    }
}