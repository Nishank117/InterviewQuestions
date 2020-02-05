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