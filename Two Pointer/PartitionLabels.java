class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for(int i = 0;i<S.length();i++){
            // We store the last occurance of each occuring character.
            lastIndex[S.charAt(i)-'a'] = i;
        }
        
        List<Integer> partitions = new ArrayList<>();
        int i = 0;
        while(i<S.length()){
            //We use the Last Index array to find the last occurance
            //of each character from the start.
            int end = lastIndex[S.charAt(i) - 'a'];
            int j = i;//important that you start from the first Index.
            while(j!=end){
                //This is kind of Intuituve now
                end = Math.max(end,lastIndex[S.charAt(j++)-'a']);
            }
            partitions.add(j-i+1);
            i = j+1;
        }
        return partitions;
    }
}