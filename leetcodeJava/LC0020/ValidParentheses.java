class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            boolean open = c=='(' || c=='{' || c=='[';
            if(open) stack.push(c);
            else
            {
                if(stack.empty()) return false;
                char elem = stack.pop();
                if      (elem=='(' && c!=')') return false;
                else if (elem=='{' && c!='}') return false;
                else if (elem=='[' && c!=']') return false;
            }
        }
        if(!stack.empty()) return false;
        return true;
    }
}