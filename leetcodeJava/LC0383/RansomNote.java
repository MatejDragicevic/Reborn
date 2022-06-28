class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // magazine -> ransomNote
        // m -> r
        int r = ransomNote.length();
        int m = magazine.length();
        if(m<r) return false;
        int[] charCount = new int['z' - 'a' + 1];
        for(int i = 0; i<m; i++)
        {
            char c = magazine.charAt(i);
            charCount[c-'a']++;
        }
        for(int i = 0; i<r; i++)
        {
            char c = ransomNote.charAt(i);
            charCount[c-'a']--;
            if(charCount[c-'a']<0) return false;
        }
        return true;
    }
}