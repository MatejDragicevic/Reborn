class Solution {
    public int[] sortByBitsPQ(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> ( sameBit(a,b) ? a-b : diffBit(a,b) )
        );
        for(int i=0; i<arr.length; i++)
            pq.add(arr[i]);
        
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            result[i] = pq.poll();
        
        return result;
    }
    
    // when you are not overthinking
    private boolean sameBit(int x, int y)
    {
        return Integer.bitCount(x) == Integer.bitCount(y);
    }
    private int diffBit(int x, int y)
    {
        return Integer.bitCount(x) - Integer.bitCount(y);
    }
    
    // when you are overthinking
    private boolean sameBitHard(int x, int y)
    {
        return bits(x) == bits(y);
    }
    private int diffBitHard(int x, int y)
    {
        return bits(x) - bits(y);
    }
    private int bits(int x)
    {
        int n = x;
        int count = 0;
        while(n!=0)
        {
            n &= n-1;
            count++;
        }
        return count;
    }
}