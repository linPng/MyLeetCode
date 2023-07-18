import java.util.HashMap;
import java.util.Map;

public class demo219 {
    //存在重复元素 II

    //哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        Map<Integer,Integer> m=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                min=Math.min(i-m.get(nums[i]),min);
            }
            m.put(nums[i],i);
        }
        if (min<=k){
            return true;
        }
        return false;
    }
    //也可以用滑动窗口

    public static void main(String[] args) {

    }
}