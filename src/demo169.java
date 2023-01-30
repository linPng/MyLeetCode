import java.util.Arrays;

public class demo169 {
    //多数元素 简单
    //排序
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //投票算法
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    public static void main(String[] args) {

    }
}
