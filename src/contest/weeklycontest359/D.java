package contest.weeklycontest359;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D {
    //2831. 找出最长等值子数组
    //分组+双指针
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size(), ans = 0;
        List<Integer>[] pos = new ArrayList[n + 1];
        Arrays.setAll(pos, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            pos[x].add(i - pos[x].size());//其他数
        }
        for (List<Integer> ps : pos) {
            if (ps.size() <= ans) continue;
            int left = 0;
            for (int right = 0; right < ps.size(); right++) {
                while (ps.get(right) - ps.get(left) > k) // 要删除的数太多了
                    left++;
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
