import java.util.*;
import java.lang.*;
import java.io.*;
public class SolutionII{
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
    public static void main(String[] args){
        FastReader fr = new FastReader();

        int t = fr.ni();
        while(t-- >0){
            int n = fr.ni();
            int temp = n;
            int[] arr = new int[n+1];
            int[] dp = new int[n+1];
            for(int i = 1;i<n+1;i++){
                arr[i] = fr.ni();
            }
            Arrays.sort(arr,1,n+1);
            int count = 1;
            for(int i = 1;i<n+1;i++){
                dp[i] = 0;
                if(i>=arr[i]){
                    dp[i] = dp[i-arr[i]] + 1;
                }else{
                    dp[i] = dp[i-1];
                }
                count = Math.max(dp[i],count);
            }
            System.out.println(count);
        }
    }
}