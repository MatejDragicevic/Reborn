class Solution {
    // turns whitespaces into "\u0000" for some reason
    public String reverseWords(String s) {
        int left = 0;
        int right = 0;
        char[] charArray = s.toCharArray();
        while(right<s.length())
        {
            while(right < s.length() && s.charAt(right) != ' ') right++;
            reverseSubstring(charArray,left,right-1);
            left = right+1;
            right++;
        }
        return new String(charArray);
    }
    public void reverseSubstring(char[] array, int start, int end)
    {
        int left = start;
        int right = end;
        while(left<right)
        {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    
    // this works
    public String reverseWordsLCVersion(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}