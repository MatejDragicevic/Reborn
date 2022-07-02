class Solution {
    // Runtime: 7 ms, faster than 94.15% of Java 
    // Memory Usage: 42.5 MB, less than 95.66% of Java
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> boxes = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i = 0; i<boxTypes.length;i++)
        {
            boxes.add(boxTypes[i]);
        }
        int sum = 0;
        int boxCount=0;
        while(boxCount<truckSize && boxes.size()>0)
        {
            int[] elem = boxes.poll();
            int numElements = Math.min(elem[0],truckSize-boxCount);
            sum += numElements*elem[1];
            boxCount += numElements;
        }
        return sum;
    }
}