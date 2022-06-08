class RemovePalindromeSubsequences {
    public int removePalindromeSub(String s) {
        if (isPalindrome(s)) return 1;
        return 2;
    }

    private boolean isPalindrome(String s) {
        int index = 0;
        int len = s.length();
        while (index <= len/2)
            if (s.charAt(index) != s.charAt(len-1-index++)) return false;
        return true;
    }
}