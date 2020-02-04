/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
     static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int ni() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    private static int findNumberOfSubArrays(int[] arr,int n,long k){
        long product = 1;
        int result = 0;
        int len;
        for(int start = 0,end = 0;end<n;end++){
            product = product*arr[end];
            while(start<end && product>=k){
                product = product/arr[start];
                start++;
            }
            
            if(product<k){
                len = (end-start)+1;
                result = result+len;
            }
        }
        return result;
    }
	public static void main (String[] args) {
		//code
		FastReader fr = new FastReader();
		int t = fr.ni();
		while(t-- > 0){
		    int n = fr.ni();
		    long k = fr.nextLong();
		    int[] arr = new int[n];
		    for(int i = 0;i<n;i++){
		        arr[i] = fr.ni();
		    }
		    System.out.println(findNumberOfSubArrays(arr,n,k));
		}
	}
}