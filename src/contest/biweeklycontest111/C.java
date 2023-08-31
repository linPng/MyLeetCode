package contest.biweeklycontest111;

import java.util.ArrayList;
import java.util.List;

public class C {
    //2826. 将三个组排序
    //最长非递减子序列
    public int minimumOperations(List<Integer> nums) {
        List<Integer> g = new ArrayList<>();
        for (int x : nums) {
            int j = upperBound(g, x);
            if (j == g.size()) g.add(x);
            else g.set(j, x);
        }
        return nums.size() - g.size();
    }

    // 开区间写法
    private int upperBound(List<Integer> g, int target) {
        int left = -1, right = g.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] <= target
            // nums[right] > target
            int mid = (left + right) >>> 1;
            if (g.get(mid) <= target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }
    public static void main(String[] args) {

    }
}
