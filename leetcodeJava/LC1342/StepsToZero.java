class StepsToZero {
    public int numberOfSteps(int num) {
        int counter = 0;
        while(num != 0){
            if(num%2 == 1){
                num -= 1;
                counter++;
                continue;
            }
            num /= 2;
            counter++;
        }
        return counter;
    }

public int numberOfStepsJava(int num) {
    return (num==0) ? 0 : Integer.numberOfTrailingZeros(Integer.highestOneBit(num)) + Integer.bitCount(num);
}
}