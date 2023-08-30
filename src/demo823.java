import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class demo823 {
    //823. 带因子的二叉树
    //动态规划
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n];//以i为父节点的情况
        long res = 0, mod = 1000000007;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int left = 0, right = i - 1; left <= right; left++) {
                while (right >= left && (long) arr[left] * arr[right] > arr[i]) {
                    right--;
                }
                if (right >= left && (long) arr[left] * arr[right] == arr[i]) {
                    if (right != left) {
                        dp[i] = (dp[i] + dp[left] * dp[right] * 2) % mod;
                    } else {
                        dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
                    }
                }
            }
            res = (res + dp[i]) % mod;
        }
        return (int) res;
    }
    public static void main(String[] args) {

    }
}
