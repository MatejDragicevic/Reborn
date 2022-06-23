class CourseScheduleIII {
    
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1]-b[1]);
        PriorityQueue<Integer> doneCourses = new PriorityQueue<>((a,b) -> b-a);
        
        int timePassed = 0;
        for(int[] currentCourse : courses)
        {
            timePassed += currentCourse[0];
            doneCourses.add(currentCourse[0]);
            if(timePassed > currentCourse[1])
            {
                timePassed -= doneCourses.poll();
            }
        }
        return doneCourses.size();
    }
}