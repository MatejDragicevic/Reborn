class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int first = 0;
        int second = 0;
        int i = 0;
        while(first<len1 || second<len2)
        {
            if(i%2==0 && first<len1) str.append(word1.charAt(first++));
            if(i%2==1 && second<len2) str.append(word2.charAt(second++));
            i++;
        }
        return str.toString();
    }
    public String mergeAlternatelyOnePointer(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0;
        while(i<len1 || i < len2)
        {
            if(i<len1) str.append(word1.charAt(i));
            if(i<len2) str.append(word2.charAt(i));
            i++;
        }
        return str.toString();
    }
}