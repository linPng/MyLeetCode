import java.util.HashMap;
import java.util.Map;

public class demo167 {
    //两数之和 II - 输入有序数组
    //题目要求常数空间,就不能用哈希表了 双指针
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
    //哈希表 实际上也能过
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i])+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
