import java.util.Arrays;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int[] height = new int[matrix[0].length];
        Arrays.fill(left,0);
        Arrays.fill(right,matrix[0].length);
        int result = 0;
        for(int i = 0;i<matrix.length;i++){
            int curr_left = 0;
            int curr_right = matrix[0].length;
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1') height[j]++;
                else{
                    height[j] = 0;
                }
            }
            // compute left (from left to right)
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]=='1') left[j]=Math.max(left[j],curr_left);
                else {left[j]=0; curr_left=j+1;}
            }
            // compute right (from right to left)
            for(int j=matrix[0].length-1; j>=0; j--) {
                if(matrix[i][j]=='1') right[j]=Math.min(right[j],curr_right);
                else {right[j]=matrix[0].length; curr_right=j;}
            }

            for(int j = 0;j<matrix[0].length;j++){
                result = Math.max(result,(right[j]-left[j])*height[j]);
            }
        }
        return result;
    }
}