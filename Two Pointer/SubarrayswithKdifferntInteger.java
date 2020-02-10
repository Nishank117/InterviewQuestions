class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
       Map<Integer, Integer> lastOccurrence = new HashMap<>();
       int count = 0;
       int wStartIndex = 0;
       // leftmost element in the window that if removed would 
       // decrease the number of different integers in the window.
       int z = 0;

        for (int wEndIndex = 0; wEndIndex < A.length; wEndIndex++) {
             lastOccurrence.put(A[wEndIndex], wEndIndex);
             if (lastOccurrence.size() > K) {
                   lastOccurrence.remove(A[z]);
                   z++;
                   wStartIndex = z;
             }
         // Advance z until it is the rightmost occurance of that integer in the window.
             while(z < lastOccurrence.get(A[z])) {
                z++;
             }
             if (lastOccurrence.size() == K) {
                count += (z - wStartIndex) + 1;
             }
            System.out.println("z:"+z+" count = "+count+" wStartIndex = "+wStartIndex);

        }
        return count;
    }
}