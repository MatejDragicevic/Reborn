class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = cardPoints.length;
        int currentSum = 0;
        int left = 0;
        int right = total-1;
        while(left < k)
        {
            currentSum +=cardPoints[left++];
        }
        if(total == k) return currentSum;
        int maxSum = currentSum;
        while(right > total-k-1)
        {
            currentSum -=cardPoints[--left];
            currentSum +=cardPoints[right--];
            maxSum = Math.max(maxSum,currentSum);
            
        }
        return maxSum;
    }
}