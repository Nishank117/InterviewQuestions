class Solution {
    public int minSwapsCouples(int[] row) {
        -------greedy solution---------
        if(row == null || row.length == 0){
            return 0;
        }
        //greedy solution
        int N = row.length;
        int[] position = new int[N];
        for(int i = 0;i<N;i++){
            position[row[i]] = i; 
        }
        int swaps = 0;
        for(int i = 0;i<N;i=i+2){
            int j = row[i]%2 == 0? row[i]+1:row[i]-1;
            if(row[i+1] != j){
                swap(row,position,i+1,position[j]);
                swaps++;
            }
        }
        return swaps;
    }
    
    private void swap(int[] row,int[] pos,int x,int y){
        int temp = row[x];
        pos[temp] = y;
        pos[row[y]] = x;
        row[x] = row[y];
        row[y] = temp;
    }

    -------Can also be done using connected components-------
    //How 
    //So ideally we should have row.length/2 number of comppnents in our output
    //if they are arranged correctly
    //and the number of swaps would ideal number of components - actual number of components
    //example [0,2,1,3]
    //we calculate 0/2 = 0,2/2 = 1 and so the component will be 0----1 for the first pair of numbers
    //1/2 = 0 and 3/2 = 1 and the component will be 0----1 for the second pair of numbers
    //ideally we should have two components but we have 1 so the number of swaps 
    //ideal components - actual components 2-1 = 1.
}