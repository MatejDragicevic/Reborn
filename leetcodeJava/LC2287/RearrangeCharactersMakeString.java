class RearrangeCharactersMakeString {
    public int rearrangeCharacters(String s, String target) {
        int[] sourceCount = new int[26];
        for(char c : s.toCharArray()){
            sourceCount[c - 'a']++;
        }
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[cha - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for(char c : target.toCharArray()) {
            min = Math.min(min, sourceCount[c - 'a'] / targetCount[c - 'a']);
        }
        return min;
    }
    public int rearrangeCharactersStreams(String s, String target) {
        int[] sourceCount = new int[26];
        s.chars().forEach(c -> sourceCount[c - 'a']++);
        int[] targetCount = new int[26];
        target.chars().forEach(c -> targetCount[c - 'a']++);
        return target.chars().map(c -> sourceCount[c - 'a'] / targetCount[c - 'a']).min().getAsInt();
    }
}