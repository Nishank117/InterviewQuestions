class Solution{
    //Idea is to have a count or like a plot of count and you need to pass through the string 
    // first time should be increase the count when we encounter a ( and decrement the count when we 
    //find a )
    //second pass vice versa but we increment the count if we encounter a star
    //in both passes
    //if at any point in the pass the count goes below 0 you return false
    // if all is well return true;
    public boolean checkValidString(String s) {
        int count = 0;
        if (s == null) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || s.charAt(i) == '(') {
                count++;
            } 
            else {
                count--;
            }
            if (count < 0) return false;          
        }
        count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '*' || s.charAt(i) == ')') {
                count++;
            } else {
                count--;
            }
            if (count < 0) return false;    
        }
        return true;
    }
}