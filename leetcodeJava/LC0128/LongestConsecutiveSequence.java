class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (a-b));
        
        for(int elem: nums) pq.add(elem);
        
        int max = 1;
        int currMax = 1;
        int prev = pq.poll();
        while(pq.size()>0)
        {
            int curr = pq.poll();
            if      (curr == prev+1)    max = Math.max(max,currMax+1);
            else if (curr==prev)        currMax--;
            else                        currMax = 0;
            
            currMax++;
            prev = curr;
        }
        return max;
    }
}