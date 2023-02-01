public class demo190 {
    //颠倒二进制位 简单 位运算
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);//最后一位移到i位
            n >>>= 1;//逻辑右移,不影响负号
        }
        return rev;
    }
    public static void main(String[] args) {

    }
}
