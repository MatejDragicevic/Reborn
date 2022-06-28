class Solution {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        for(int i = 0; i<accounts.length; i++)
        {
            int customerWealth = 0;
            for(int j = 0; j<accounts[i].length; j++)
            {
                customerWealth += accounts[i][j];
            }
            richest = Math.max(richest, customerWealth);
        }
        return richest;
    }
    
    public int maximumWealthStream(int[][] accounts) {
        return Arrays
            .stream(accounts)
            .mapToInt(i -> Arrays
                      .stream(i)
                      .sum())
            .max()
            .getAsInt();
    }
}