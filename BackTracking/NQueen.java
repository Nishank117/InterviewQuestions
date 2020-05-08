import java.util.*;

public class NQueen{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = 0;
            }
        }

    }
    private boolean isSafe(int[][] board,int row,int col){
        int i,j;
        for(i = 0; i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }
        //upper diagonal
        for(i = row,j = col;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        //lower diagonal
        for(i = row,j = col;i<board.length && j>=0 ;i++,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    private boolean solveNQueenUtil(int[][] board,int col){
        if(col>=board.length){
            return true;
        }
        for(int i = 0;i<board.length;i++){
            if(isSafe(board,i,col)){
                if(solveNQueenUtil(board,col+1)){
                    return true;
                }
                board[i][col]= 0;//backtrack
            }
        }
        return false;
    }

}