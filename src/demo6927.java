import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class demo6927 {
    //
    //超时
    public int maximumBeauty2(int[] nums, int k) {
        int maxBeauty = 0;
        Map<Integer, Integer> beautyMap = new HashMap<>();
        for (int num : nums) {
            for(int i=num-k;i<=num+k;i++){
                beautyMap.put(i,beautyMap.getOrDefault(i,0)+1);
            }
        }
        for(int n:beautyMap.keySet()){
            maxBeauty=Math.max(maxBeauty,beautyMap.get(n));
        }
        return maxBeauty;
    }

    //经典排序双指针
    public int maximumBeauty(int[] nums, int k) {
        int maxBeauty = 0;
        Arrays.sort(nums);
        int left=0;
        for(int right=left;right<nums.length;right++){
            while(nums[left]+2*k<nums[right]){
                left++;
            }
            maxBeauty=Math.max(maxBeauty,right-left+1);
        }
        return maxBeauty;
    }

    //投票算法 经典
    public int maximumBeauty3(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>(); // 记录每个数字的出现次数
        int maxBeauty = 0; // 最大美丽值

        for (int num : nums) {
            // 计算当前数字可以取得的最小值和最大值
            int min = Math.max(0, num - k);
            int max = num + k;

            // 更新数字的出现次数
            countMap.put(min, countMap.getOrDefault(min, 0) + 1);
            countMap.put(max + 1, countMap.getOrDefault(max + 1, 0) - 1);
        }

        int currCount = 0; // 当前位置的数字出现次数
        for (int i = 0; i <= 100000; i++) { // 假设数组元素范围在 [0, 100000]
            currCount += countMap.getOrDefault(i, 0);
            maxBeauty = Math.max(maxBeauty, currCount);
        }

        return maxBeauty;
    }
    public static void main(String[] args) {

    }
}