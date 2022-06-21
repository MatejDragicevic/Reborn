class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> notRepeated = new HashSet<Character>();
        
        int maxSize = 0;
        while(right < s.length())
        {
            char endChar = s.charAt(right);
            boolean notPresent = notRepeated.add(endChar);
            if(notPresent)
            {
                maxSize = Math.max(maxSize, right - left + 1);
            }
            else
            {
                while(s.charAt(left++) != endChar)
                {
                    notRepeated.remove(s.charAt(left-1));
                }
            }
            right++;
        }
        return maxSize;
    }
}