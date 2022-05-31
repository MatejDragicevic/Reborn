class ContainBinarySizeK {
    public boolean hasAllCodes(String s, int k) {
        int countDown = 1<<k;
        Set<String> setSubstrings = new HashSet<String>();
        for (int i = 0; i+k <= s.length(); i++) {
            String tempSubstring = s.substring(i, i+k);
            if(!setSubstrings.contains(tempSubstring)) {
                setSubstrings.add(tempSubstring);
                countDown--;
                if(countDown==0) return true;
            }
        }
        return false;
    }
    public boolean hasAllCodesRollingHash(String s, int k) {
        int countDown = 1 << k;
        boolean[] gotSubstringHash = new boolean[countDown];
        int allOne = countDown - 1;
        int hashVal = 0;
        //https://en.wikipedia.org/wiki/Rolling_hash
        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i-k+1,i+1)
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
            // hash only available when i-k+1 >= 0
            if (i >= k - 1 && !gotSubstringHash[hashVal]) {
                gotSubstringHash[hashVal] = true;
                countDown--;
                if (countDown == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}