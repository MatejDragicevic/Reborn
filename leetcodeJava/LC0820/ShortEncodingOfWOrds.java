class TrieNode {
    public TrieNode[] children;
    public int height;
    public TrieNode() {
        children = new TrieNode[26];
        height = 0;
    }
}
class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for(int i = 0;i<words.length;i++)
        {
            insert(root,words[i]);
        }
        
        Stack<TrieNode> stack = new Stack<>();
        stack.add(root);
        
        int size = 0;
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            int childCount = 0;
            for (TrieNode child: node.children) {
                if(child != null)
                {
                    childCount++;
                    stack.add(child);
                }
            }
            if (childCount == 0) size += node.height + 1;
        }
        
        return size;
    }
    
    private void insert(TrieNode root, String word) {
        for (int i=word.length()-1; i>=0; i--) {
            char c = word.charAt(i);
            if (root.children[c - 'a'] == null) 
                root.children[c - 'a'] = new TrieNode();
            int tempHeight = root.height;
            root = root.children[c - 'a'];
            root.height = tempHeight + 1;
        }
    }
}