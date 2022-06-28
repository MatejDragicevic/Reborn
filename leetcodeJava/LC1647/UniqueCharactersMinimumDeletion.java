class Solution {
    public int minDeletions(String s)
    {
        int[] lcArray = getLetterCountArray(s);
        
        PriorityQueue<Integer> lcQueue = getLetterCountQueue(lcArray);
        
        return getDeletedLetterCount(lcQueue);
    }
    
    public int[] getLetterCountArray(String s)
    {
        int[] lc = new int['z'-'a' + 1];
        for(int i = 0; i < s.length(); i++)
            lc[s.charAt(i) - 'a'] += 1;
        return lc;
        
    }
    
    public PriorityQueue<Integer> getLetterCountQueue(int[] lca)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<lca.length; i++)
            if(lca[i] != 0)
                pq.add( lca[i] );
        return pq;
    }
    
    public int getDeletedLetterCount(PriorityQueue<Integer> lcq)
    {
        int lowest = Integer.MAX_VALUE;
        int total = 0;
        while(lcq.size() > 0)
        {
            int highest = lcq.poll();
            lowest = Math.min(lowest-1, highest);
            total += highest-lowest;
            
            if(lowest == 0) lowest++;
        }
        return total;        
    }
}