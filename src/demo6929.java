import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo6929 {
    //合法分割的最小下标
    public int minimumIndex(List<Integer> numsl) {
        int[] nums = numsl.stream().mapToInt(Integer::intValue).toArray();
        int n = nums.length;

        // 计算支配元素及其出现次数
        int dominantElement = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                dominantElement = num;
                count = 1;
            } else if (dominantElement == num) {
                count++;
            } else {
                count--;
            }
        }

        // 验证支配元素是否满足条件
        int freq = 0;
        for (int num : nums) {
            if (num == dominantElement) {
                freq++;
            }
        }
        if (freq * 2 <= n) {
            return -1; // 支配元素不满足条件
        }

        // 寻找合法分割的最小下标
        int leftCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == dominantElement) {
                leftCount++;
            }
            if (leftCount > (i + 1) / 2 && freq - leftCount > (n - i - 1) / 2) {
                return i;
            }
        }

        return -1; // 未找到合法分割
    }
    public static void main(String[] args) {

    }
}