import java.util.HashMap;
import java.util.Map;

public class demo1 {
    //两数之和 简单
    //哈希表
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{0};
    }
    //暴力
    public int[] twoSum2(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0};
    }

    public static void main(String[] args) {

    }
}
