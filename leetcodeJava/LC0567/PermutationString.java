class Solution {
    public boolean checkInclusion(String s1, String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;
        int[] charArray = new int['z'-'a'+1];
        for(int i = 0; i<n1;i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            charArray[c1-'a']++;
            charArray[c2-'a']--;
        }
        
        if(isArrayZero(charArray)) return true;
        
        for(int i = n1; i<n2;i++)
        {
            char rightC = s2.charAt(i);
            char leftC = s2.charAt(i-n1);
            charArray[rightC-'a']--;
            charArray[leftC-'a']++;
            if(isArrayZero(charArray)) return true;
        }
        return false;
    }
    
    public boolean isArrayZero(int[] arr)
    {
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i]!=0) return false;
        }
        return true;
    }
}