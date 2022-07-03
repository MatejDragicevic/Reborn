class Solution {
    private static final long MODULO_VALUE = 1000000007L;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        long toConvert = (long) getCutSide(h, horizontalCuts);
        toConvert *= (long) getCutSide(w, verticalCuts);
        
        return (int) (toConvert % MODULO_VALUE);
    }
    
    // if you can modify the cuts array
    private int getCutSide(int len, int[] cuts)
    {
        Arrays.sort(cuts);
        int n = cuts.length;
        
        int side = cuts[0];
        for(int i = 1; i<n; i++)
            side = Math.max(side, cuts[i]-cuts[i-1]);
        side = Math.max(side, len - cuts[n-1]);
        
        return side;
    }
    
    // if you can't modify the cuts array
    private int getCutSidePQ(int len, int[] cuts)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        
        for(int elem : cuts)
            pq.add(elem);
                
        int side = pq.poll();
        int max = side;
        for(int i = 1; i<cuts.length; i++)
        {
            int current = pq.poll();
            side = Math.max(side, current - max);
            max = current;
        }
        side = Math.max(side, len-max);
        
        return side;
    }
}