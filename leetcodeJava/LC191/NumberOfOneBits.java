/**
 * NumberOfOneBits
 */
public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String unsignedInt = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i<unsignedInt.length(); i++) {
            if(unsignedInt.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
    public int hammingWeightOneLine(int n) {
        return Integer.bitCount(n);
    }
}