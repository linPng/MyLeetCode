import java.util.HashMap;
import java.util.Map;

public class demo6289 {
    //查询数组 Xor 美丽值
    //暴力解 超时
    public static int xorBeauty(int[] nums) {
        int ret=0;
        int n=nums.length;
        Map<String,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    int t;
                    String key=i>j?String.valueOf(j)+String.valueOf(i)+String.valueOf(k):String.valueOf(i)+String.valueOf(j)+String.valueOf(k);
                    if(map.containsKey(key)){
                        t=map.get(key);
                    }else{
                        t=((nums[i] | nums[j]) & nums[k]);
                        map.put(key,t);
                    }
                    ret=ret^t;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + xorBeauty(new int[]{1,4}));
        System.out.println(" = " + xorBeauty(new int[]{15,45,20,2,34,35,5,44,32,30}));
    }

}