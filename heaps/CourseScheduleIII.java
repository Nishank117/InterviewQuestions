class Solution {
    public int scheduleCourse(int[][] courses) {
        //we need to maximise the number of courses one can take here
        //so we need to put in some kind of an greedy approach to solve this problem
        //what will be greedy about is the number of courses we can complete

        //we sort our array so that it is aligned with the deadlines
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        // we use a max heap so that we can always have the highest time consuming course at the top 
        // and remove it whenever neccessary.
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int totalTime = 0;
        for(int[] course:courses){
            //we add a course 
            totalTime+=course[0];
            queue.offer(course[0]);
            //check if it exceeds the totaltime
            //if it does remove the previously most time consuming course.
            if(totalTime > course[1]){
                int sub = queue.poll();
                totalTime -= sub;
            }
        }
        
       return queue.size();
    }
}