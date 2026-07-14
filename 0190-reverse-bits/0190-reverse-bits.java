class Solution {
    
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;          // make room for next bit
            res |= (n & 1);     // add lowest bit of n
            n >>= 1;            // shift n right
        }
        return res;
    }

}