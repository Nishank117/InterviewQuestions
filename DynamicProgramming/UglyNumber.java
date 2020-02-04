
import java.util.*;
import java.lang.*;
import java.io.*;

class UglyNumber {
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
    
	public static void main (String[] args) {
		//code
		FastReader fr = new FastReader();
		int t = fr.ni();
		while(t-->0){
		    int n = fr.ni();
		    long[] arr = new long[n];
		    int i2 = 0;
		    int i3 = 0;
		    int i5 = 0;
		    arr[0] = 1;
		    long next_multiple_of_2 = 2;
		    long next_multiple_of_3 = 3;
		    long next_multiple_of_5 = 5;
		    long next_ugly = 1;
		    for(int i = 1;i<n;i++){
		        next_ugly = Math.min(next_multiple_of_2,Math.min(next_multiple_of_3,next_multiple_of_5));
		        arr[i] = next_ugly;
		        if(next_ugly == next_multiple_of_2){
		            i2 = i2+1;
		            next_multiple_of_2 = arr[i2]*2;
		        }
		        if(next_ugly == next_multiple_of_3){
		            i3 = i3+1;
		            next_multiple_of_3 = arr[i3]*3;
		        }
		        if(next_ugly == next_multiple_of_5){
		            i5 = i5+1;
		            next_multiple_of_5 = arr[i5]*5;
		        }
		        
		    }
		  //  int result = findMinimum(arr,0,n-1);
		    System.out.println(Math.abs(arr[n-1]));
		    
		}
	}
}