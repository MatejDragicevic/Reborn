class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] charArray = new int['z'-'a'+1];
        for(int i = 0; i<s.length(); i++)
        {
            charArray[s.charAt(i)-'a']++;
            charArray[t.charAt(i)-'a']--;
        }
        for(int elem : charArray)
        {
            if(elem!=0) return false;
        }
        return true;
    }
}