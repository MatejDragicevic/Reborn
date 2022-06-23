class Solution {
    public double average(int[] salary) {
        int max = 0;
        int min = 1000000;
        int sum = 0;
        for(int elem : salary)
        {
            sum += elem;
            min = Math.min(min,elem);
            max = Math.max(max,elem);
        }
        return (double) (sum-min-max)/(salary.length-2);
    }
}