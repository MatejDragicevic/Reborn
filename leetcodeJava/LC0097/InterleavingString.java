class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        char[] third = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(first, second, third, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    private boolean dfs(char[] first, char[] second, char[] third, int one, int two, int three, boolean[][] invalid) {
        if(invalid[one][two]) return false;
        if(three == third.length) return true;
        boolean valid = 
            one < first.length &&
            first[one] == third[three] &&
            dfs(first, second, third, one + 1, two, three + 1, invalid)
            || 
            two < second.length &&
            second[two] == third[three] &&
            dfs(first, second, third, one, two + 1, three + 1, invalid);
        if(!valid) invalid[one][two] = true;
        return valid;
    }
}