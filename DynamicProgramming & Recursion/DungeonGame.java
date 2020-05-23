class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minInitHealth = new int[m][n];
        for(int i = m-1;i>=0;i-- ){
            for(int j = n-1;j>=0;j--){
                if(i == m-1 && j == n-1){
                   minInitHealth[i][j] = Math.max(1,1-dungeon[i][j]);
                }else if(i == m-1){
                    minInitHealth[i][j] = Math.max(1,minInitHealth[i][j+1]-dungeon[i][j]);
                }else if(j == n-1){
                    minInitHealth[i][j] = Math.max(1,minInitHealth[i+1][j] - dungeon[i][j]);
                }else{
                    minInitHealth[i][j] = Math.max(1,Math.min(minInitHealth[i][j+1],minInitHealth[i+1][j])-dungeon[i][j]);
                }
            }
        }
        return minInitHealth[0][0];
    }
}