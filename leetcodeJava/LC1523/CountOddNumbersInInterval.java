class CountOddNumbersInInterval {
    public int countOdds(int low, int high) {
        if(high == low && high%2==0) return 0; 
        if(high - low < 2) return 1;
        int bonus = low%2==1 || high%2==1 ? 1:0;
        return (high - low)/2 + bonus;
    }
    
    public int countOddsOptimal(int low, int high) {
        //
        return (high+1)/2 - low/2;
    }
}