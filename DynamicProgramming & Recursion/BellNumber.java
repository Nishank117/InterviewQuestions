import java.util.*;

import GFG.FastReader;

import java.io.*;

//Use Bell triangle
//1
//1 2
//2 3 5
//5 7 10 15
//15 20 27 37 52
The triangle is constructed using below formula.

// If this is first column of current row 'i'
If j == 0
   // Then copy last entry of previous row
   // Note that i'th row has i entries
   Bell(i, j) = Bell(i-1, i-1) 

// If this is not first column of current row
Else 
   // Then this element is sum of previous element 
   // in current row and the element just above the
   // previous element
   Bell(i, j) = Bell(i-1, j-1) + Bell(i, j-1)
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