class MaxProductWordLength {

    public int maxProduct(String[] words) {
        int lenWords = words.length;
        List<Set<Character>> charSetList = new ArrayList(lenWords);
        for (String word : words) {
            Set<Character> setChars = new HashSet();
            for (int i = 0; i < word.length(); i++) {
                setChars.add( word.charAt(i) );
            }
            charSetList.add( setChars );
        }
        int max = 0;
        for(int i = 0; i<lenWords; i++){
            Set<Character> iSet = charSetList.get(i);
            for(int j=i+1; j<lenWords; j++) {
                boolean hasCommon = false;
                Set<Character> jSet = charSetList.get(j);
                for(Character c : iSet) {
                    if(jSet.contains(c)) {
                        hasCommon = true;
                        break;
                    }
                }
                if(hasCommon == false) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    public int maxProductBitMask(String[] words) {
        int n = words.length;
        int[] bitmask = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < words[i].length(); k++) {
                int index = words[i].charAt(k) - 'a';
                //add a bit to the bitmask if not already present
                //the bit represents each character of the alphabet
                // a is on index 0 as in 000001
                // b is on index 1 as in 000010 ...
                bitmask[i] = bitmask[i] | (1 << index);
            }
            // iterate only over the previous entries
            // those entries have the bitmask set
            for (int j = 0; j < i; j++) {
                boolean hasNoCommon = (bitmask[i] & bitmask[j]) == 0;
                int product = words[i].length() * words[j].length();
                if(hasNoCommon) {
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }
}