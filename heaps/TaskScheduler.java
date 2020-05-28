import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //frequency map
        Map<Character,Integer> charMap = new HashMap<>();
        for(char c:tasks){
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
        maxHeap.addAll(charMap.values());
        int cycles = 0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<=n;i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.remove());
                }
            }

            for(int i:temp){
                if(--i>0){
                    //we add the char with frequency greater than 1 to the maxheap again and decrement their 
                    //frequency
                    maxHeap.add(i);
                }
            }
            //for the last cycle Maxheap will be empty
            cycles += maxHeap.isEmpty() ? temp.size():n+1;
        }
        return cycles;
    }
}