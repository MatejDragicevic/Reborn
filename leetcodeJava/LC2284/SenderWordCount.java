class SenderWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> senderWordCount = new HashMap<String, Integer>();
        int max = 0;
        String result = "";
        for(int i = 0; i<messages.length;i++) {
            int wordCount = messages[i].split("\\s+").length;
            if(senderWordCount.containsKey(senders[i])) {
                wordCount += senderWordCount.get(senders[i]);
            }
            if(wordCount>max) {
                max = wordCount;
                result = senders[i];
            } else if(wordCount==max) {
                if(senders[i].compareTo(result)>0) {
                    result = senders[i];
                }
            }
            senderWordCount.put(senders[i], wordCount);
        }
        return result;
    }
    public String largestWordCountTreeSet(String[] messages, String[] senders) {
        Map<String, Integer> senderWordCount = new HashMap<String, Integer>();
        int max = 0;
        String result = "";
        for(int i = 0; i<messages.length;i++) {
            max = Math.max(
                    max,
                    senderWordCount.merge(
                            senders[i],
                            messages[i].split("\\s+").length,
                            Integer::sum
                    )
            );
        }
        TreeSet<String> senderSet = new TreeSet<>();
        for(var entry : senderWordCount.entrySet()) {
            if(entry.getValue() == max) senderSet.add(entry.getKey());
        }
        return senderSet.pollLast();
    }
}