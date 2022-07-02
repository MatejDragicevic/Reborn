class Solution {
    public String toLowerCase(String s) {
        char[] charArray = new char[s.length()];
        int aTillA = 'a'-'A';
        for(int i = 0; i<s.length();i++)
        {
            char c = s.charAt(i);
            boolean isUpper = c>='A' && c<='Z';
            char newChar = isUpper ? (char)(c + aTillA) : c;
            charArray[i] = newChar;
        }
        return String.valueOf(charArray);
    }
    public String toLowerCaseOneLiner(String s) {
        return s.toLowerCase();
    }
}