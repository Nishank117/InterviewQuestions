class Solution {
    public int scheduleCourse(int[][] courses) {
        //we need to maximise the number of courses one can take here
        //so we need to put in some kind of an greedy approach to solve this problem
        //what will be greedy about is the number of courses we can complete
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int totalTime = 0;
        for(int[] course:courses){
            totalTime+=course[0];
            queue.offer(course[0]);
            if(totalTime > course[1]){
                int sub = queue.poll();
                totalTime -= sub;
            }
        }
        
       return queue.size();
    }
}