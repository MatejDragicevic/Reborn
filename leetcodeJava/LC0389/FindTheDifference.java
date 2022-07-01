class Solution {
    public char findTheDifference(String s, String t) {
        char[] letters = new char['z'-'a'+1];
        
        char x = t.charAt(t.length()-1);
        if(s.length() == 0) return x;
        letters[x-'a']++;
        
        for(int i = 0; i<s.length();i++)
        {
            letters[s.charAt(i)-'a']--;
            letters[t.charAt(i)-'a']++;
        }
        for(int i = 0; i<letters.length;i++)
        {
            if(letters[i]!=0) x = (char)('a'+ i);
        }
        return x;
    }
    public char findTheDifferenceBitWise(String s, String t) {
        char x = t.charAt(t.length()-1);
        if(s.length() == 0) return x;
        for(int i = 0; i<s.length(); i++)
        {
            x ^= s.charAt(i);
            x ^= t.charAt(i);
        }
        return x;
    }
}