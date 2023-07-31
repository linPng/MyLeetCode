import java.util.Arrays;

public class demo6957 {
    //统计范围内的步进数字数目
    //经典数位dp
    private static final int MOD = (int) 1e9 + 7;

    public int countSteppingNumbers(String low, String high) {
        return (calc(high) - calc(low) + MOD + (valid(low) ? 1 : 0)) % MOD; // +MOD 防止算出负数
    }

    private char s[];
    private int memo[][];

    private int calc(String s) {
        this.s = s.toCharArray();
        int m = s.length();
        memo = new int[m][10];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return f(0, 0, true, false);
    }

    private int f(int i, int pre, boolean isLimit, boolean isNum) {
        if (i == s.length)
            return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
        if (!isLimit && isNum && memo[i][pre] != -1)
            return memo[i][pre];
        int res = 0;
        if (!isNum) // 可以跳过当前数位
            res = f(i + 1, pre, false, false);
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 s 的一样，那么这一位至多填数字 s[i]（否则就超过 s 啦）
        for (int d = isNum ? 0 : 1; d <= up; d++) // 枚举要填入的数字 d
            if (!isNum || Math.abs(d - pre) == 1) // 第一位数字随便填，其余必须相差 1
                res = (res + f(i + 1, d, isLimit && d == up, true)) % MOD;
        if (!isLimit && isNum)
            memo[i][pre] = res;
        return res;
    }
    private boolean valid(String s) {
        for (int i = 1; i < s.length(); i++)
            if (Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1)) != 1)
                return false;
        return true;
    }
    public static void main(String[] args) {

    }
}