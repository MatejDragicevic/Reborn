class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1 && target[0] != 1) return false;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(long elem : target)
        {
            sum += elem;
            pq.add(elem);
        }
        
        while(sum>=target.length)
        {
            long highest = pq.poll();
            if(highest==1) return true;
            long diff = sum - highest;
            long times = (highest - 1)/diff;
            if(times<1) return false;
            highest -= diff*times;
            pq.add(highest);
            sum -= diff*times;
        }
        return false;
    }
}