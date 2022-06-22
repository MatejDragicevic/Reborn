import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> climbQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<heights.length-1; i++)
        {
            int climb = heights[i+1] - heights[i];
            if(climb > 0)
            {
                bricks -= climb;
                climbQueue.add(climb);

                if(bricks < 0)
                {
                    bricks += climbQueue();
                    if(ladders > 0) ladders--;
                    else return i;
                }
            }
        }
        return heights.length - 1;
    }
}