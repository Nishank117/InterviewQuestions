class Solution {

    //AunionBunionC we need to find.
    public long gcd(long a, long b) 
    { 
       if( a < b) return gcd(b,a);
        if( b == 0 ) return a;
        return gcd(b,a%b);
    } 
    public long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
   
    public int nthUglyNumber(int n, int a, int b, int c) {
        long along = a;
        long blong = b;
        long clong = c;
        long nlong = n;
        long low =1;
        long high = Integer.MAX_VALUE;
        while(low<high){
            long mid = (low+high)/2;
            long intersection = ((mid/along)+(mid/blong)+(mid/clong)-(mid/lcm(along,blong))-(mid/lcm(blong,clong))-(mid/lcm(clong,along))+(mid/lcm(along,lcm(blong,clong))));
            
            if(intersection == n){
                return Math.toIntExact(intersection);
            }
            
            if(intersection<n){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return Math.toIntExact(low);
    }
}