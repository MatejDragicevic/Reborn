class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i = 0; i<n.length();i++)
        {
            int digit = Character.getNumericValue(n.charAt(i));
            max = Math.max(max,digit);
            if(max == 9) break;
        }
        return max;
    }
}