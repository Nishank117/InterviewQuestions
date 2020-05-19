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
    
        int n = fr.ni();
        int k = fr.ni();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(fr.ni());
        }
        int[] q = new int[k];
        for(int j = 0;j<k;j++){
            q[j] = fr.ni();
        }
        Collections.sort(list);
        
        for(int j = 0;j<k;j++){
            if(q[j]<0){
                int index = Math.abs(q[j]);
                if(index-1<list.size())
                    list.remove(index-1);
            }else{
                list.add(q[j]);
            }
        }
        if(list.size() == 0){
            System.out.println(0);
        }else{
            System.out.println(list.get(0));
        }
    }
}