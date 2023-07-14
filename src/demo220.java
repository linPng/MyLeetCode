import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo220 {
    //存在重复元素 III

    //哈希表 超时
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff){
        int min=Integer.MAX_VALUE;
        Map<Integer,Integer> m=new HashMap();
        for(int i=0;i<nums.length;i++){
            int t=nums[i];
            for (int q=t-valueDiff;q<=t+valueDiff;q++) {
                if(m.containsKey(q)){
                    min=Math.min(i-m.get(q),min);
                }
            }
            m.put(nums[i],i);
        }
        if (min<=indexDiff){
            return true;
        }
        return false;
    }
    //也可以用滑动窗口 还是超时
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int indexDiff, int valueDiff){
        Set s = new HashSet();
        for(int i=0;i<nums.length;i++){
            if(s.size()>indexDiff){
                s.remove(nums[i-indexDiff-1]);
            }
            for (int j = nums[i]-valueDiff;j<=nums[i]+valueDiff;j++) {
                if(s.contains(j)){
                    return true;
                }
            }
            s.add(nums[i]);
        }
        return false;
    }
    //桶排序
    long size;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
         size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i] * 1L;
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(r) && map.get(r) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) map.remove(getIdx(nums[i - k] * 1L));
        }
        return false;
    }
    long getIdx(long u) {
        //负数要另外处理:
        return u >= 0 ? u / size : ((u + 1) / size) - 1;
    }
    public static void main(String[] args) {
        demo220 d=new demo220();
        System.out.println("this.containsNearbyAlmostDuplicate() = " +
                d.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
    }
}