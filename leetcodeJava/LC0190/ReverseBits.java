public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        int bitCheck = 1;
        int bitEdit = 1<<31;
        for(int i=0; i<32; i++)
        {
            if((n & bitCheck) != 0) reversed |= bitEdit; //or sets true
            else                    reversed &= ~bitEdit;//inverse and sets false
            
            bitCheck <<= 1;
            bitEdit >>>= 1; // '>>' makes all bits till the end 1 for some reason
        }
        return reversed;
    }
}