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
    private static void addNumbers(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers,int number){
        if(lowers.size() == 0 || lowers.peek()>number){
            lowers.add(number);
        }else{
            highers.add(number);
        }
    }
    private static void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        
        if(lowers.size()-highers.size() > 1 )
        {
            highers.add(lowers.poll());
        }else if(highers.size()-lowers.size() > 1 ){
            lowers.add(highers.poll());
        }
    }
    private static int getMedianValue(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size() ? lowers:highers;
        PriorityQueue<Integer> smallerHeap = lowers.size()>highers.size() ? highers:lowers;
        
        if(biggerHeap.size() == smallerHeap.size() ){
            return (biggerHeap.peek()+smallerHeap.peek())/2;
        }else{
            return biggerHeap.peek();
        }
    }
    private static int[] getMedians(int[] array,int n){
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        int[] median = new int[n];
        for(int i = 0;i<n;i++){
            int number = array[i];
            addNumbers(lowers,highers,number);
            rebalance(lowers,highers);
            median[i] = getMedianValue(lowers,highers);
        }
        return median;
    }
	public static void main (String[] args) {
		//code
		FastReader fr = new FastReader();
		int n = fr.ni();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++){
		    arr[i] = fr.ni();
		}
		int[] median = getMedians(arr,n);
		for(int i = 0;i<n;i++){
		    System.out.println(median[i]);
		}
	}
}

//another efficient approach
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
    }

    public void addNum(int num) {
        if(num<findMedian()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        if(maxHeap.size()>minHeap.size()){
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == 0 && maxHeap.size() == 0) return 0;
        if(minHeap.size() == maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }else{
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */