import java.util.HashMap;
import java.util.Map;

public class demo6293 {
    //统计好子数组的数目
    public static long countGood(int[] nums, int k) {
        long ret=0;
        int n=nums.length;
        Map<Integer,Integer> map_dp=null;
        for(int i=0;i<n;i++){
            map_dp=new HashMap<>();
            for(int j=i;j<n;j++){
                map_dp.put(nums[j], map_dp.getOrDefault(nums[j],0)+1);
                int kn=0;
                for(int key:map_dp.keySet()){
                    int t=map_dp.get(key);
                    kn+=t*(t-1)/2;
                }
                if(kn>=k){
                    ret++;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + countGood(new int[]{3,1,4,3,2,2,4},2));
    }

}