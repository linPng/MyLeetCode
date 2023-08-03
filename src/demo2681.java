import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo2681 {
    //英雄的力量
    //排序+动态规划
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] preSum = new int[nums.length + 1];
        int res = 0, mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = (nums[i] + preSum[i]) % mod;
            preSum[i + 1] = (preSum[i] + dp[i]) % mod;
            res = (int) ((res + (long) nums[i] * nums[i] % mod * dp[i]) % mod);
            if (res < 0) {
                res += mod;
            }
        }
        return res;
    }
    public int sumOfPower2(int[] nums) {
        Arrays.sort(nums);
        int dp = 0, preSum = 0;
        int res = 0, mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            dp = (nums[i] + preSum) % mod;
            preSum = (preSum + dp) % mod;
            res = (int) ((res + (long) nums[i] * nums[i] % mod * dp) % mod);
            if (res < 0) {
                res += mod;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
