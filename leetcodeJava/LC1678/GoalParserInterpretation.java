class Solution {
    public String interpret(String command) {
        StringBuilder str = new StringBuilder();
        int left = 0;
        for(int right = 0; right<command.length();right++)
        {
            char currentChar = command.charAt(right);
            if( currentChar != '(')
            {
                str.append(currentChar);
            }
            else
            {
                left = right++;
                
                if(command.charAt(right)==')')
                {
                    str.append('o');
                    continue;
                }
                else if(command.charAt(right)=='a'
                         && command.charAt(++right)=='l'
                         && command.charAt(++right)==')')
                {
                    str.append("al");
                    continue;
                }
                else
                {
                    while(left<right)
                    {
                        str.append(command.charAt(left++));
                    }
                }
            }
        }
        return str.toString();
    }
    public String interpretIfYouReadTheQuestionsConstraints(String command) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<command.length();i++)
        {
            // (...
            if(command.charAt(i)=='(')
            {
                // ()
                if(command.charAt(++i)==')')
                {
                    str.append('o');
                }
                // (al)
                else
                {
                    str.append("al");
                    i+=2;
                }
            }
            // G
            else str.append('G');
        }
        return str.toString();
    }
}