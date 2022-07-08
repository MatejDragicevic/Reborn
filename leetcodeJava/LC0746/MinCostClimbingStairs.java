class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n<2) return 0;
        int prev = cost[0];
        int mid = cost[1];
        for(int i=2; i<n; i++)
        {
            int temp = cost[i] + Math.min(prev,mid);
            prev = mid;
            mid = temp;
        }
        return Math.min(prev, mid);
    }
}