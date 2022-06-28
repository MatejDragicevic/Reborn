class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> charCount = new HashMap<>();
        for(int i = 0; i<s.length(); i++)
        {
            charCount.merge(s.charAt(i), 1, Integer::sum);
        }
        int sum = 0;
        boolean oneOdd = false;
        for(int digits : charCount.values())
        {
            if(!oneOdd)
            {
                oneOdd = digits%2==1;
            }
            sum += (digits/2)*2;
        }
        if(oneOdd) sum++;
        return sum;
    }
}