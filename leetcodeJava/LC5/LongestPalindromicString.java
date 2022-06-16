class LongestPalindromicString {
    public String longestPalindrome(String s) {
        int total = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[total][total];

        for (int raidus=0; raidus<total; raidus++) {
            for (int mid=0; mid+raidus<total; mid++) {
                dp[mid][mid+raidus] = s.charAt(mid) == s.charAt(mid+raidus) && (raidus < 2 || dp[mid+1][mid+raidus-1]);
                if (dp[mid][mid+raidus] && raidus > end - start) {
                    start = mid;
                    end = mid + raidus;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}