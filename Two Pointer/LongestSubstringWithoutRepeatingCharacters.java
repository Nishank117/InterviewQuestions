class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> charIndex = new HashMap<>();
        
        int length = 0;
        for(int i = 0,j = 0;i<s.length();i++){
            if(charIndex.containsKey(s.charAt(i))){
                int temp = charIndex.get(s.charAt(i));
                //we check the last appearance of the character if it is greater than equal 
                //to j we change j
                if(temp>=j){
                    j = temp+1;
                }else{
                    length = Math.max(length,i-j+1);
                }
            }else{
                length = Math.max(length,i-j+1);
            }
            charIndex.put(s.charAt(i),i);
        }
        return length;
    }
}
Two key points to the solution:
1.An import rule to reduce the number of comparisons
This problem can be solved by finding the longest substring that starts with each character and does not contain duplicate characters, and then returning the longest substring length.
Take abcdcaf for example. When we start to look for the longest substring starting with the character with index 0 (a), we will find that the character with index 2 are the same as the character with index 4 (both are c), so we do not need to consider that the substrings starting with the characters with index 1 (b) or index 2 (c) may be the longest substrings, because the substrings starting with b or c are impossible longer than the substring starting with a

2.A data structure that can quickly determine whether a character already exists
Based on the above rules, when we judge that the characters with index 2 and 4 are the same (both are c), we can start to find the longest substring from the character d with index 3. If we can use a data structure to quickly determine whether character a (index 5) is included in the substring dc starting with d, we can further improve the efficiency of the algorithm.

The mapping from character to character index can meet this requirement. We add all the characters traversed in the loop to the key of the map, and put the index into the corresponding value. Let's start to determine if character a exists in the substring dc. Character a exists in the map, but the index is 0, and the start index of dc substring is 3 , so character a is not in the substring DC.