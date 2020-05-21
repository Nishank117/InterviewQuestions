class Solution {
    public int longestDecomposition(String text) {
        if(text == null || text.length() == 0){
            return 0;
        }
        int n = text.length();
        for(int i = 0;i<n/2;i++){
            // this is intuitive
            if(text.substring(0,i+1).equals(text.substring(n-(i+1),n)))
                return 2+longestDecomposition(text.substring(i+1,n-(i+1)));
        }
        return 1;
    }
}