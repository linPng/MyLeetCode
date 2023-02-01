public class demo191 {
    //位1的个数 简单 位运算
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
