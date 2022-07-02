class Solution {
    public String freqAlphabets(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='#')
            {
                // turn the 2nd char before # into int
                int offset = (s.charAt(i-2)-'0')*10;
                // turn the first char before # into int
                offset += (s.charAt(i-1)-'0');
                // remove 10 to have the right offset from j till z
                offset -= 10;
                str.append((char)(offset+'j'));
                i -= 2;
            }
            else
            {
                str.append((char)(s.charAt(i)-'1'+'a'));
            }
        }
        return str.reverse().toString();
    }
}