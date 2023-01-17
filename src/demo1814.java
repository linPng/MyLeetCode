import java.util.HashMap;
import java.util.Map;

public class demo1814 {
    //统计一个数组中好对子的数目
    // nums[i]+rev(nums[j])=rev(nums[i])+nums[j] 转换为 nums[i]-rev(nums[i])=nums[j]-rev(nums[j])
    public int countNicePairs(int[] nums) {
        int ret=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            int t=i-rev(i);
            ret=(ret+map.getOrDefault(t,0))%1000000007;
            map.put(t,map.getOrDefault(t,0)+1);
        }
        return ret;
    }
    //位数反转
    public int rev(int x){
        int ret=0;
        while(x>0){
            ret*=10;
            ret+=x%10;
            x=x/10;
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}