class Solution {
    //Our main goal is to make k swaps so that we can get the string B from A
    //we make two things one being a HashSet of seen which takes into account 
    //all the strings which are converted from A after swaps
    //second is our queue to run the BFS on the graph made
    public int kSimilarity(String A, String B) {
        if(A == null || B == null ||A.length() == 0 || B.length() == 0){
            return 0;
        }
        HashSet<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        seen.add(A);
        queue.offer(A);
        int changes = 0;
        while(!queue.isEmpty()){
            for(int size = queue.size(); size > 0; size--){
                String str = queue.poll();
                if(str.equals(B)) return changes;
                int i = 0;
                //we try to find the first breaking point 
                while(i<str.length() && str.charAt(i) == B.charAt(i)){
                    i++;
                }
                //so the point where it breaks we find the same index in string B
                //when done we swap and add it to queue
                //but we don't add any other
                for(int j = i+1;j<str.length();j++){
                    if(str.charAt(j) == B.charAt(i)){
                        String newStr = swap(i,j,str);
                        if(!seen.contains(newStr)){
                            queue.offer(newStr);
                            seen.add(newStr);
                        }
                    }
                }
            }
            changes++;
        }
        return changes;
    }
    private String swap(int x,int y, String str){
        char[] cArr = str.toCharArray();
        char temp = cArr[x];
        cArr[x] = cArr[y];
        cArr[y] = temp;
        return new String(cArr);
    }
}