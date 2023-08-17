package contest.weeklycontest89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D {
    //854. 相似度为 K 的字符串
    public int kSimilarity(String s1, String s2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                str1.append(s1.charAt(i));
                str2.append(s2.charAt(i));
            }
        }
        int n = str1.length();
        if (n == 0) {
            return 0;
        }
        List<Integer> smallCycles = new ArrayList<Integer>();
        List<Integer> largeCycles = new ArrayList<Integer>();
        for (int i = 1; i < (1 << n); i++) {
            int[] cnt = new int[6];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    cnt[str1.charAt(j) - 'a']++;
                    cnt[str2.charAt(j) - 'a']--;
                }
            }
            boolean isCycle = true;
            for (int j = 0; j < 6; j++) {
                if (cnt[j] != 0) {
                    isCycle = false;
                    break;
                }
            }
            if (isCycle) {
                int size = Integer.bitCount(i);
                if (size <= 6) {
                    smallCycles.add(i);
                } else {
                    largeCycles.add(i);
                }
            }
        }
        Collections.sort(smallCycles, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
        Collections.sort(largeCycles, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
        int[] dp = new int[1 << n];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 0; i < smallCycles.size(); i++) {
            for (int j = 0; j < i; j++) {
                int x = smallCycles.get(i), y = smallCycles.get(j);
                if ((x & y) == y) {
                    dp[x] = Math.max(dp[x], dp[y] + dp[x ^ y]);
                }
            }
        }
        for (int x : largeCycles) {
            for (int y : smallCycles) {
                if ((x & y) == y) {
                    dp[x] = Math.max(dp[x], dp[y] + dp[x ^ y]);
                }
            }
        }
        return n - dp[(1 << n) - 1];
    }
    public static void main(String[] args) {

    }
}
