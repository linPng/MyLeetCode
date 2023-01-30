public class demo172 {
    //阶乘后的零 中等 数学 5^n
    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }
    //优化
    public int trailingZeroes2(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("'' = " + trailingZeroes(20));
    }
}
