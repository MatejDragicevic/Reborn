class Solution {
    public boolean backspaceCompare(String s, String t) {
        return reduceString(s).equals(reduceString(t));
    }
    private String reduceString(String x)
    {
        StringBuilder str = new StringBuilder();
        int index = x.length()-1;
        int toDelete = 0;
        while(index>=0)
        {
            char current = x.charAt(index);
            if(current=='#') toDelete++;
            else if (toDelete==0) str.append(current);
            else toDelete--;
            index--;
        }
        return str.reverse().toString();
    }
}