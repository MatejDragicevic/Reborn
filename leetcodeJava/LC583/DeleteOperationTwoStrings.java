class Solution {
    
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lcs(word1, word2, word1.length(), word2.length());
    }
    public int lcs(String word1, String word2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (word1.charAt(m - 1) == word2.charAt(n - 1))
            return 1 + lcs(word1, word2, m - 1, n - 1);
        else
            return Math.max(lcs(word1, word2, m, n - 1), lcs(word1, word2, m - 1, n));
    }
    
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        return word1.length() + word2.length() - 2 * lcs(word1, word2, word1.length(), word2.length(), memo);
    }
    public int lcs(String word1, String word2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] > 0)
            return memo[m][n];
        if (word1.charAt(m - 1) == word2.charAt(n - 1))
            memo[m][n] = 1 + lcs(word1, word2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs(word1, word2, m, n - 1, memo), lcs(word1, word2, m - 1, n, memo));
        return memo[m][n];
    }
    public int minDistance(String word1, String word2) {
        
    }
}