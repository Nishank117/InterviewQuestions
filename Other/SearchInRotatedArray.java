class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        //binary search to find the pivot
        int left = 0;
        int right = nums.length-1;
        
        //binary search to find the pivot
        while(left<right){
            int midpoint = left +(right-left)/2;
            System.out.println(midpoint);
            
            //our aim should to find a subarray which is unsorted.
            if(nums[midpoint]>nums[right]){
                //if true we know the left side of the array has the pivot because
                //our pivot is the smallest element in the array
                //left subarray is sorted
                //so the boundary elements in the new subarray will always have elements which will
                //always have one element i.e left being greater than the right element which shows 
                //the pivot is in between.
                left = midpoint+1;
            }else{
                //if this is the case the right subarray is sorted
                //vice versa case as before
                right = midpoint;
            }
        }

        System.out.println("pivot is"+left);
        
        int start = left;
        left = 0;
        right = nums.length-1;
        //setting boundaries for the final binary search
        if(target>= nums[start] && target<=nums[right]){
            left = start;
        }else{
            right = start;
        }
        
        while(left<=right){
            int midpoint = left+(right-left)/2;
            if(nums[midpoint] == target){
                return midpoint;
            }else if(nums[midpoint]<target){
                left = midpoint+1;
            }else{
                right = midpoint-1;
            }
        }
        return -1;
    }
    
}