import java.util.*;

import GFG.FastReader;

import java.io.*;

public class BellNumber{
    //try to solve with bell triangle.
    static int BellNumberFinder(int n,int k){
        int[][] arr = new int[n+1][n+1];
        bell[0][0] = 1;
        for(int i = 1;i<n+1;i++){
            bell[i][0] = bell[i-1][i-1];
            for(int j = 1;j<=i;j++){
                bell[i][j] = bell[i][j-1]+bell[i-1][j-1];
            }

        }
        return 0;
    }
    public static void main(String[] args){
        FastReader fr = new FastReader();
        int t = fr.ni();
        while(t-->0){
            int n = fr.ni();
            int k = fr.ni();
            System.out.println(BellNumberFinder(n, k));

        }
    }
}