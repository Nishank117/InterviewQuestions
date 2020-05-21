import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] histogram) {
        if(histogram == null||histogram.length == 0){
            return 0;
        }
        if(histogram.length == 1){
            return histogram[0];
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        while(i<histogram.length){
            if(stack.isEmpty() || histogram[stack.peek()]<=histogram[i]){
                stack.push(i++);
            }else{
                int currentMax = stack.pop();
                int area = histogram[currentMax]*(stack.isEmpty()? i:(i-1-stack.peek()));
                maxArea = Math.max(area,maxArea);
            }
        }
        while(!stack.isEmpty()){
            int currentMax = stack.pop();
            int area = histogram[currentMax]*(stack.isEmpty()?i:i-1-stack.peek());
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }
}