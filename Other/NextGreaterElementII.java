class Solution {
    //Idea to solve this is to make a array size double the size of the given array to form the 
    //circular array.
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null){
            return new int[0];
        }
        int n = nums.length;
        int[] doubleArray = new int[2*n];
        for(int i = 0;i<n;i++){
            int x = n+i;
            doubleArray[i] = nums[i];
            doubleArray[x] = nums[i];
        }
        for(int i = 0;i<n;i++){
            boolean flag = false;
            for(int j = i;j<2*n-1;j++){
                if(nums[i]<doubleArray[j]){
                    nums[i] = doubleArray[j];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                nums[i] = -1;
            }
        }
        return nums;
    }
}