class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneQue = new PriorityQueue<Integer>((a,b) -> b-a);
        for(int elem : stones) stoneQue.add(elem);
        while(stoneQue.size()>1)
        {
            int bigger = stoneQue.poll();
            int big = stoneQue.poll();
            if(bigger!=big) stoneQue.add(bigger-big);
        }
        return stoneQue.size()>0 ? stoneQue.poll() : 0;
    }
}